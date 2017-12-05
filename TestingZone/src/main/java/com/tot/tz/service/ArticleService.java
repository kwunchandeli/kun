package com.tot.tz.service;

import java.util.List;

import com.tot.tz.entity.Article;

public interface ArticleService {
	public List<Article> getHotArticles();
	public List<Article> getLimitArticles(int i,int start,int end);
}
