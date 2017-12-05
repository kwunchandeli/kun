package com.tot.tz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tot.tz.dao.ArticleDao;
import com.tot.tz.dao.PlateDao;
import com.tot.tz.entity.Article;
import com.tot.tz.entity.Plate;
import com.tot.tz.service.ArticleService;
import com.tot.tz.service.PlateService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDao articleDao;

	@Override
	public List<Article> getLimitArticles(int p_id, int start, int end) {
		return articleDao.getLimitArticles(p_id, start, end);
	}

	@Override
	public List<Article> getHotArticles() {
		return articleDao.getHotArticles();
	}




}
