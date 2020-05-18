package com.hblg.web.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.hblg.exception.UserException;
import com.hblg.pojo.User;
import com.hblg.service.impl.UserServiceImpl;
@WebServlet("/user/*")
public class UserServlet extends BaseServlet{

	/**
	 *  serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//1.创建userServiceImpl类的类对象，把结果返回到servlet
	UserServiceImpl us = new UserServiceImpl();
	public void register(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//2.创建类对象
		User user = new User();
		//补全字段
		//激活码
		user.setActiveCode(UUID.randomUUID().toString());
		//角色
		user.setRole("普通用户");
		//时间
		user.setRegistTime(new Date());
		try {
			//3.把接收的数据转换成bean
			BeanUtils.populate(user, request.getParameterMap());
//			System.out.println(user);
			//4.注册
			us.add(user);
			
			request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
		} catch (UserException e) {
			// TODO: handle exception
			request.setAttribute("register_error", e.getMessage()+"注册失败，用户名重复");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
