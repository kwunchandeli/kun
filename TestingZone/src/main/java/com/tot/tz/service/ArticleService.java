package com.tot.tz.service;

import java.util.List;
import java.util.Map;

import com.tot.tz.dto.ArticleDto;
import com.tot.tz.entity.Article;

public interface ArticleService {
	public List<Article> getHotArticles();
	public List<Article> getLimitArticles(int p_id,int start,int end);
	public List<Article> geMytLimitArticles(int u_id,int start,int end);
	public Map<String, Object> getPagingArticles(int p_id,int perPage,int page);
	public Map<String, Object> getMyPagingArticles(int u_id,int perPage,int page);
	public Article getArticleById(int a_id);
	public int saveOrUpdateArticle(ArticleDto articleDto);
	public Article updatePageView(int a_id,int u_id);
}
