package com.tot.tz.service;

import com.tot.tz.entity.User;

public interface UserService {
	public User getUserByIp(String u_ip);
	public String getUsernameByIp(String u_ip);
}
