package com.dao.it;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.entity.it.Book;
import com.helper.it.BeanRowMapper;
import com.helper.it.DBhelper;

public class BookDAO {
	Scanner rece = new Scanner(System.in);
	DBhelper<Book> db = new DBhelper<>(Config.URL);
	BeanRowMapper<Book> be = new BeanRowMapper<>(Book.class);
	
	public boolean revise(String code) {
		// 修改
		Book book = new Book();
		book.setTitle(getstr("书名："));
		book.setAuthor(getstr("作者："));
		book.setPress(getstr("出版社："));
		book.setStation(getstr("状态：【在库】或【借出】"));
		String sql = "UPDATE `book` SET title=?,author=?,press=?,station=? WHERE (`code`=?)";

		return db.doupdate(sql, book.getTitle(), book.getAuthor(), book.getPress(), book.getStation(), code) >= 1;
	}
	public boolean revise(Book book) {
		// 修改
//		Book book = new Book();
//		book.setTitle(getstr("书名："));
//		book.setAuthor(getstr("作者："));
//		book.setPress(getstr("出版社："));
//		book.setStation(getstr("状态：【在库】或【借出】"));
//		if(find(book.getCode()) == null){
//			return false;
//		}
		String sql = "UPDATE `book` SET title=?,author=?,press=?,station=? WHERE (`code`=?)";
		return db.doupdate(sql, book.getTitle(), book.getAuthor(), book.getPress(), book.getStation(), book.getCode()) >= 1;
	}

	private String getstr(String msg) {
		System.out.println("请输入" + msg);
		return rece.next();
	}

//	private int getint(String msg) {
//		System.out.println("请输入" + msg);
//		if (rece.hasNextInt()) {
//			return rece.nextInt();
//		} else {
//			System.out.println(msg + "含有非数字，请重新输入：");
//			return getint(msg);
//		}
//	}

	public Book find(String code) {
		String sql = "select * from book where code =?";
		return db.doquery(sql, be, code);
	}

	public List<Book> show() {
		String sql = "select title,author,press,count(1) total,sum(station ='在库') remain FROM book GROUP BY title";
		return db.doquery(sql, be);
	}
	public List<Book> showall() {
		String sql = "select code,title,author,press,station FROM book order by code ";
		return db.doquery(sql, be);
	}
	public List<Book> showall(String str) { 
		if(str.length() > 7){
			return showall();
		}
		String like =" code like '%" + str+ "%' or title like '%" + str+ "%' or author like '%" + str+ "%' or press like '%" + str+ "%'  ";
		String sql = "select code,title,author,press,station FROM book where" + like + "order by code";
		// System.out.println(sql);
		return db.doquery(sql, be);
	}

	public boolean delete(String code) {
		String sql = "delete from book where code =? and btime > 0";
		return db.doupdate(sql, code) == 1;
	}
	public boolean deletebook(String code) {
		String sql = "delete from book where code =? and station=\"在库\"";
		// System.out.println(sql);
		return db.doupdate(sql, code) > 0;
	}

	public int insert(String code, int num) {
		int i = 0;
		String sql = "INSERT INTO `book` (`code`, `title`, `author`, `press`) VALUES (?, ?, ?, ?)";
		Book book = new Book();
		book.setTitle(getstr("书名："));
		book.setAuthor(getstr("作者："));
		book.setPress(getstr("出版社："));
		while (++i <= num) {
			book.setCode(code + "0" + i);
			// System.out.println(book.getCode());
			db.doupdate(sql, book.getCode(), book.getTitle(), book.getAuthor(), book.getPress());
		}
		return i;
	} 
	public int addbook(Book book, int num) { 
		
		int i = 0;
		String sql = "INSERT INTO `book` (`code`, `title`, `author`, `press`) VALUES (?, ?, ?, ?)";
		String code = book.getCode(); 
		// System.out.println(code.length());
		if(code.length() > 4) {
			if( find(code) == null){
				return db.doupdate(sql, book.getCode(), book.getTitle(), book.getAuthor(), book.getPress());
			} else{
				return -1;
			}
		} else {
			if (find(code + "01") != null){
				System.out.println("BookDAO:该书号已经被占用！");
				return -1;
			}
			while (++i <= num) {
				book.setCode(code + "0" + i);
				db.doupdate(sql, book.getCode(), book.getTitle(), book.getAuthor(), book.getPress());
			}
			return i;	
		}	
	}
	public boolean update(String bcode, String fu) {
		String sql = "SELECT btime FROM book where `code` = ?";
		Book book = new Book();
		book = db.doquery(sql, be, bcode);
		Integer time = book.getBtime();
        System.out.println(time);
		if (fu.equals("+")) {
			time++;
			String sql1 = "UPDATE `book` SET station=?,btime=? WHERE (`code`=?)";
			return db.doupdate(sql1, "借出", time, bcode) == 1;
		} else if (fu.equals("-")) {
			String sql1 = "UPDATE `book` SET station=?,btime=? WHERE (`code`=?)";
			return db.doupdate(sql1, "在库", time, bcode) == 1;
		} else{
			return false;
		}
		
	}
		

	public boolean access(String bcode) {
		String sql = "select `code`, station FROM book where  title = ( SELECT title FROM book WHERE `code` = ?)";
		List<Book> list = new ArrayList<>();
		// 获取书名相同，书号不同的  书号和状态
		list = db.doque(sql, be, bcode);
		int n = list.size();
		if(n == 0) {
			System.out.println("图书号不存在或未上架！");
			return true;
		}
		System.out.println(n);
		System.out.println(123);
		for (Book book : list) { 
		//	n--;
			if(book.getCode().equals(bcode)){  // 得到书号
				 if(book.getStation().equals("借出")){  // 判断是否借出
					 System.out.println("本书已经借出...");
					 System.out.println("推荐借阅：");
					 for (Book bo : list) {
						if(bo.getStation().equals("在库")){
							System.out.println(bo.getCode());
						}
					 }
					 return true; // 不能借
				 } else{
					 return false;  // 可以借
				 }
			}
		} 
		System.out.println("某有匹配到书号！");
		return false;
	}
	
	
}
