package com.dao.it;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Time {

	public int time (String btime) {

		Date date = new Date();
		DateFormat format;
		format = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
		String nowdate = format.format(date);
		SimpleDateFormat datetemp = new SimpleDateFormat("yyyy-MM-dd");
		Date temp1 = new Date();
		Date temp2 = new Date();
		try {
			temp1 = datetemp.parse(nowdate);
			temp2 = datetemp.parse(btime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long sec = temp1.getTime() - temp2.getTime();
		sec = sec/1000/60/60/24;
		return (int)sec + 1;
	}

}
