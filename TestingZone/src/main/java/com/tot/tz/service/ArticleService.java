package com.tot.tz.service;

import java.util.List;
import java.util.Map;

import com.tot.tz.entity.Article;

public interface ArticleService {
	public List<Article> getHotArticles();
	public List<Article> getLimitArticles(int i,int start,int end);
	public Map<String, Object> getPagingArticles(int p_id,int perPage,int page);
}
