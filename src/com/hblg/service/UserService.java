package com.hblg.service;

import com.hblg.exception.UserException;
import com.hblg.pojo.User;

public interface UserService {

	//注册方法
	public void add(User user) throws UserException;
}
