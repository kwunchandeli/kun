package com.tot.tz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tot.tz.dao.UserDao;
import com.tot.tz.entity.User;
import com.tot.tz.service.UserService;

@Service("userService")
public class UseServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public User getUserByIp(String u_ip) {
		return this.userDao.getUserByIp(u_ip);
	}

	@Override
	public String getUsernameByIp(String u_ip) {
		User user = userDao.getUserByIp(u_ip);
		if(user == null){
			return "未注册用户";
		}
		return user.getU_name();
	}

}
