package com.tot.tz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tot.tz.dto.ArticleDto;
import com.tot.tz.entity.Article;

public interface ArticleDao {
	public List<Article> getHotArticles();
	public List<Article> getLimitArticles(@Param("p_id") int p_id,@Param("start") int start,@Param("end") int end);
	public List<Article> getMyLimitArticles(@Param("u_id") int u_id,@Param("start") int start,@Param("end") int end,@Param("status") String status);
	public int getCountByPlateid(@Param("p_id") int p_id);
	public int getCountByUid(@Param("u_id") int u_id,@Param("status") String status);
	public int getAcount();
	public int getPvcount();
	public Article getArticleById(int a_id);
	public void saveArticle(ArticleDto articleDto);
	public void editArticle(ArticleDto articleDto);
	public void updatePageView(@Param("a_id") int a_id);
}
