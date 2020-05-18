package com.hblg.service.impl;

import java.sql.SQLException;

import com.hblg.dao.impl.UserDaoImpl;
import com.hblg.exception.UserException;
import com.hblg.pojo.User;
import com.hblg.service.UserService;

public class UserServiceImpl implements UserService{
	//创建userDaoImpl的类对象
	UserDaoImpl dao = new UserDaoImpl();
	@Override
	public void add(User user) throws UserException {
		// TODO Auto-generated method stub
		try {
			//1.通过dao对象名调用方法传递结果
			dao.add(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("注册失败");
		}
	}

}
