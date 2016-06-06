package com.dao.it;

import java.util.List;

import com.entity.it.Card;
import com.helper.it.BeanRowMapper;
import com.helper.it.DBhelper;

public class CardDAO {
	DBhelper<Card> db = new DBhelper<Card>(Config.URL);
	BeanRowMapper<Card> be = new BeanRowMapper<>(Card.class);

	public boolean update(String ccode, String fu) {
		String sql = "SELECT ctime,count FROM card where `code` = ?";
		Card card = new Card();
		card = db.doquery(sql, be, ccode);
		Integer time = card.getCtime();
		Integer count = card.getCount();
		time++;
		if (fu.equals("+")) {
			count++;
		} else if (fu.equals("-")) {
			count--;
		}
		String sql1 = "update card set ctime=?,count=? where `code` = ?";
		return db.doupdate(sql1, time, count, ccode) == 1;
	}

	public List<Card> show() {
		String sql = "SELECT * FROM card ORDER BY code";
		return db.doquery(sql, be);
	}

	public boolean delete(String code) {
		if (find(code).getCount() > 0) {
			System.out.println("还有书未还！！！");
			return false;
		} else {
			String sql = "delete from card where code=?";
			return db.doupdate(sql, code) > 0;
		}
	}
	public Card find(String code) {
		String sql = "select * from card where code=?";
		Card card = db.doquery(sql, be, code);
		return card;
	}
	public Card login(String code, String pass) {
		String sql = "select * from card where code=? and pass =?";
		Card card = db.doquery(sql, be, code, pass);
		return card;
	}

	public boolean update(Card card) {
		// set 之间要加,
		String sql = "update card set user=?,tel=?, ctime=?,count=? where `code` = ?";
		System.out.println(card.toString());
		return db.doupdate(sql, card.getUser(), card.getTel(), card.getCtime(), card.getCount(), card.getCode()) > 0;
	}
	public boolean insert(Card card) {
		// set 之间要加,
		if(find(card.getCode()) != null){
			System.out.println("卡号已经存在！");
			return false;
		}
		String sql = "INSERT INTO `card` (`code`, `user`, `tel`) VALUES (?,?,?)";
		System.out.println(card.toString());
		return db.doupdate(sql, card.getCode(),card.getUser(), card.getTel()) > 0;
	}

}
