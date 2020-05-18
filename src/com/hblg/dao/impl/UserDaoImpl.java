package com.hblg.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.hblg.dao.UserDao;
import com.hblg.pojo.User;
import com.hblg.utils.C3P0Utils;

public class UserDaoImpl implements UserDao{

	@Override
	public void add(User user) throws SQLException {
		// TODO Auto-generated method stub
		//1.获取sql执行对象QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//2.书写sql
		String sql = "insert into "
				+ "user(username,PASSWORD,gender,email,telephone,introduce,"
				+ "activeCode,state,role,registTime) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		//3.执行sql
		qr.update(sql, user.getUsername(),user.getPassword(),user.getGender(),
				user.getEmail(),user.getTelephone(),user.getIntroduce(),
				user.getActiveCode(),user.getState(),user.getRole(),user.getRegistTime());
	}

}
