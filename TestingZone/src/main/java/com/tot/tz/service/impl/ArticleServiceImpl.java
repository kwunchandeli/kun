package com.tot.tz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tot.tz.dao.ArticleDao;
import com.tot.tz.dao.PlateDao;
import com.tot.tz.dto.ArticleDto;
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
	public List<Article> geMytLimitArticles(int u_id, int start, int end,String status) {
		return articleDao.getMyLimitArticles(u_id, start, end,status);
	}
	
	@Override
	public List<Article> getHotArticles() {
		return articleDao.getHotArticles();
	}

	@Override
	public Map<String, Object> getPagingArticles(int p_id,int perPage,int page){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = articleDao.getCountByPlateid(p_id);
		if(page>(count/perPage + 1)){
			page = count/perPage + 1;
		}
		if(page<1){
			page = 1;
		}
		List<Article> aList = articleDao.getLimitArticles(p_id, perPage*(page-1), perPage);
		map.put("count", count);
		map.put("page", page);
		map.put("perPage", perPage);
		map.put("aList", aList);
		return map;
	}

	@Override
	public Article getArticleById(int a_id) {
		return articleDao.getArticleById(a_id);
	}

	@Override
	public int saveOrUpdateArticle(ArticleDto articleDto) {
		if(articleDto.getA_id() == 0){
			articleDao.saveArticle(articleDto);
		}else {
			articleDao.editArticle(articleDto);
		}
		return articleDto.getA_id();
	}

	@Override
	public Article updatePageView(int a_id,int u_id) {
		Article article = articleDao.getArticleById(a_id);
		if(a_id != 0 && article.getU_id() != u_id){
			articleDao.updatePageView(a_id);
		}
		return article;
	}

	@Override
	public Map<String, Object> getMyPagingArticles(int u_id,int perPage,int page,String status){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = articleDao.getCountByUid(u_id,status);
		if(page>(count/perPage + 1)){
			page = count/perPage + 1;
		}
		if(page<1){
			page = 1;
		}
		List<Article> aList = articleDao.getMyLimitArticles(u_id, perPage*(page-1), perPage,status);
		map.put("count", count);
		map.put("page", page);
		map.put("perPage", perPage);
		map.put("aList", aList);
		return map;
	}

	
}
