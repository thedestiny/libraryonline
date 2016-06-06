package com.servers.it;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class BRbook {
	public String borrowbook(String bcode, String ccode) {
		String msg = callpro("{CALL PRO_bobook(?,?,?)}", bcode, ccode);
		System.out.println(msg);
		return msg;
	}
	public String returnbook(String bcode, String ccode) {
		
		return callpro("{CALL PRO_rebook(?,?,?)}", bcode, ccode);
	}
	public String returnbook(String bcode) {
		
		return callpro("{CALL PRO_rebookv(?,?)}", bcode);
	}

	private String callpro(String sql, String bcode, String ccode) {
		String msg = "";
		try {
			Connection con = DriverManager.getConnection(com.dao.it.Config.URL);
			CallableStatement csmt = con.prepareCall(sql);
			csmt.setString(1, bcode);
			csmt.setString(2, ccode);
			csmt.executeQuery();
			msg = csmt.getString(3);
			System.out.println("call: " + msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	private String callpro(String sql, String bcode) {
		String msg = "";
		try {
			Connection con = DriverManager.getConnection(com.dao.it.Config.URL);
			CallableStatement csmt = con.prepareCall(sql);
			csmt.setString(1, bcode);
			csmt.executeQuery();
			msg = csmt.getString(2);
			msg = msg + "," + csmt.getString(3);
			System.out.println("call: " + msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
}
