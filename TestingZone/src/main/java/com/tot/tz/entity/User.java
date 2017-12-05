package com.tot.tz.entity;

public class User {
	private int u_id;

	private String u_name;

	private String u_ip;

	private String role;

	public User() {
		super();
	}
	
	public int getU_id() {
		return u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public String getU_ip() {
		return u_ip;
	}

	public String getRole() {
		return role;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public void setU_ip(String u_ip) {
		this.u_ip = u_ip;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
