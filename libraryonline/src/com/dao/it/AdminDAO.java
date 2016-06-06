package com.dao.it;

import com.entity.it.Admin;
import com.helper.it.BeanRowMapper;
import com.helper.it.DBhelper;


public class AdminDAO {
	
	DBhelper<Admin> db = new DBhelper<Admin>(Config.URL);
	BeanRowMapper<Admin> be = new BeanRowMapper<>(Admin.class);
	
	public boolean find(String user, String pwd) {
		String sql = "select * from admin where guanli=? and password=?";
		return db.doquery(sql, be, user,pwd) != null;
	}
	
	
}
