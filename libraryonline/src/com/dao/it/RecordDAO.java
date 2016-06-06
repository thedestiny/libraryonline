package com.dao.it;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.entity.it.Record;
import com.helper.it.BeanRowMapper;
import com.helper.it.DBhelper;

public class RecordDAO {
	// DBhelper constructor 必须写成可见  public 不能不写
	DBhelper<Record> db = new DBhelper<Record>(Config.URL);
	BeanRowMapper<Record> be = new BeanRowMapper<>(Record.class);
	
	public boolean insert(String bcode, String ccode) {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		BookDAO bdao = new BookDAO();
		CardDAO cdao = new CardDAO();
		// 借书  先判断是否借 查找书籍的 code 和 station 列表
		if(bdao.access(bcode)){
			return false;
		}
		String sql = "INSERT INTO `record` (`bcode`, `ccode`, `bcstate`, `brtime`) VALUES (?, ?, ?, ?)";
		Record record = new Record();
		record.setCcode(ccode);
		record.setBcode(bcode);
		record.setBcstate("借出");
		record.setBrtime(df.format(now));
		//record.getBcstate()
		// 查询借书卡的借阅总次数和当前借书总数
		//cdao.update(ccode,"+");
		//bdao.update(bcode,"+");
		if(cdao.update(ccode,"+") && bdao.update(bcode,"+")){
			// System.out.println("没有找到");
			return db.doupdate(sql, record.getBcode(),record.getCcode(),"借出",record.getBrtime()) != 0;
			
		} else{
			System.out.println("逻辑错误");
			return false;
		}
		
	}
	public boolean update(String bcode, String ccode) {
		//还书
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Record record = new Record();
		CardDAO cdao = new CardDAO();
		BookDAO bdao = new BookDAO();
		String sql = "UPDATE `record` SET `bcstate`=?, `retime`=?,`bday`=? WHERE (bcode=? and ccode=?)";
		record.setBcstate("已还");
		record.setRetime(df.format(now)); 
		String sq = "select brtime FROM record WHERE bcode = ? AND ccode = ?";
		Record rec = new Record();
		rec = db.doquery(sq, be, bcode,ccode);
		String btime = rec.getBrtime();
		Time ti = new Time();
		Integer bday = ti.time(btime);
		// cdao.update(ccode,"-");
		// bdao.update(bcode,"-");
		if(cdao.update(ccode,"-") && bdao.update(bcode,"-")){
			// System.out.println("没有找到");
			return db.doupdate(sql,record.getBcstate(),record.getRetime(),bday,bcode,ccode) == 1;
		} else{
			System.out.println("逻辑错误");
			return false;
		}
	}
	public List<Record> show(){
		String sql = "SELECT * from record order by bcode";
		return db.doquery(sql, be);
	} 
	public List<Record> findccode(String ccode){
		String sql = "SELECT * from record where ccode =? order by bcode";
		return db.doque(sql, be, ccode);
	} 
	public List<Record> findbcode(String bcode){
		String sql = "SELECT * from record where bcode =? order by bcode";
		return db.doque(sql, be, bcode);
	} 
	

}
