package com.tot.tz.dto;

import java.util.Date;

public class ArticleDto {
	private int a_id;
	private int p_id;
	private int u_id;
	private String title;
	private String content;
	private String status;
	
	public ArticleDto() {
		super();
	}
	
	public int getA_id() {
		return a_id;
	}
	public int getP_id() {
		return p_id;
	}
	public int getU_id() {
		return u_id;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}

	public String getStatus() {
		return status;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
