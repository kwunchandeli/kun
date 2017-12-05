package com.tot.tz.dao;

import java.util.List;

import com.tot.tz.entity.Article;

public interface ArticleDao {
	public List<Article> getHotArticles();
	public List<Article> getLimitArticles(int p_id,int start,int end);

}
