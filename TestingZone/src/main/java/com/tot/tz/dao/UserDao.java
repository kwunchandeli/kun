package com.tot.tz.dao;

import com.tot.tz.entity.User;

public interface UserDao {
	public User getUserByIp(String u_ip);
}
