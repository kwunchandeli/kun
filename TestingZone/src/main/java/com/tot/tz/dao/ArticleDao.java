package com.tot.tz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tot.tz.entity.Article;

public interface ArticleDao {
	public List<Article> getHotArticles();
	public List<Article> getLimitArticles(@Param("p_id") int p_id,@Param("start") int start,@Param("end") int end);
	public int getCountByPlateid(@Param("p_id") int p_id);

}
