package com.helper.it;

import java.sql.ResultSet;
import java.sql.SQLException;
// �������ͽӿ� 
public interface Entitybuild <T>{
   T build(ResultSet res) throws SQLException;
}
