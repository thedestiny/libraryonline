package com.helper.it;

import java.sql.ResultSet;
import java.sql.SQLException;
// 创建泛型接口 
public interface Entitybuild <T>{
   T build(ResultSet res) throws SQLException;
}
