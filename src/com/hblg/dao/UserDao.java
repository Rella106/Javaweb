package com.hblg.dao;

import java.sql.SQLException;

import com.hblg.pojo.User;

public interface UserDao {
	//注册方法ע
	public void add(User user) throws SQLException;

}
