package com.tot.tz.entity;

import java.util.Date;

public class Article {
	private int a_id;
	private int p_id;
	private String title;
	private String content;
	private Date create_time;
	private String p_name;
	private int pv;
	private String u_name;

	public Article() {
		super();
	}

	public int getA_id() {
		return a_id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public String getP_name() {
		return p_name;
	}

	public int getPv() {
		return pv;
	}

	public String getU_name() {
		return u_name;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

}
