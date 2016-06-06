package com.entity.it;

public class Card {

	private Integer id;
	private String code;
	private String pass;
	private String user;
	private String tel;
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	private Integer ctime;
	private Integer count;

	public Integer getCtime() {
		return ctime;
	}

	public void setCtime(Integer time) {
		this.ctime = time;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", code=" + code + ", user=" + user + ", tel=" + tel +":  " + ctime +":  " +  count +  "]";
	}
	
}
