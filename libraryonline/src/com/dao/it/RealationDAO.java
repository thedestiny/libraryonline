package com.dao.it;

import java.util.List;

import com.entity.it.Realation;
import com.helper.it.BeanRowMapper;
import com.helper.it.DBhelper;

public class RealationDAO {
	DBhelper<Realation> db = new DBhelper<>(Config.URL);
	BeanRowMapper<Realation> be = new BeanRowMapper<>(Realation.class);
	
	public List<Realation> findbcode(String bcode){
		String sql = "SELECT * FROM view_bc WHERE bcode=? order by brtime"; 
		return db.doque(sql, be, bcode);
	} 
	public List<Realation> findccode(String ccode){
		String sql = "SELECT * FROM view_bc WHERE ccode=? order by brtime"; 
		System.out.println("Ö´ÐÐÃ»£¿");
		return db.doque(sql, be, ccode);
	} 
	
	
}
