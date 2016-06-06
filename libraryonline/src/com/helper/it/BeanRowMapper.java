package com.helper.it;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BeanRowMapper<T> implements Entitybuild<T> {

	private Class<T> type;

	public BeanRowMapper(Class<T> type) {
		this.type = type;
	}

	@Override
	public T build(ResultSet res) throws SQLException {
		T obj = null;
		try {
			obj = type.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// res 是查询结果  type 是类型   res.getObject()获取值  res.getMetaData()获取列抬头
		// 获取列名 抬头 
		ResultSetMetaData rsmd = res.getMetaData();
		// 获取type的方法数组 类型的方法
		Method[] me = type.getMethods(); 
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			// 获取每列的名字 并且 组装set方法
			String colname = rsmd.getColumnLabel(i);
			//System.out.println(rsmd.getColumnName(i)+" " +rsmd.getColumnTypeName(i)+" "+rsmd.getColumnType(i)+" "+rsmd.getColumnClassName(i));
			
			colname = colname.substring(0, 1).toUpperCase() + colname.substring(1);
			// System.out.println("shijian");
			colname = "set" + colname;
			// System.out.println(colname);
			// 在方法数组中 搜索对应方法
			for (Method method : me) {
				if (method.getName().equals(colname)) {
					try {
						// 反射 y=f(x)与 f(y,x)
						if(res.getObject(i) == null){
							System.out.println("BeanRowMapper值为空");
							method.invoke(obj, "--");
							break;
						} else if (res.getObject(i) instanceof Integer){
							method.invoke(obj, 0);
						}
						method.invoke(obj, res.getObject(i));
						//System.out.println("i" + res.getObject(i));
					} catch (Exception e) {
						// System.out.println("zheli");
						 e.printStackTrace();
					}
					break;
				}
			}
		}
		//System.out.print("bean");
		//System.out.println(obj.toString());
		return obj;
	}

}
