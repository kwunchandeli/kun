package com.tot.tz.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tot.tz.dao.ArticleDao;
import com.tot.tz.dao.PlateDao;
import com.tot.tz.service.StatisticsService;

@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {
	
	@Resource
	private ArticleDao articleDao;
	
	@Resource
	private PlateDao plateDao;
	
	@Override
	public Map<String, Integer> getStatistics() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pCount", plateDao.getPcount());
		map.put("aCount", articleDao.getAcount());
		map.put("pvCount", articleDao.getPvcount());
		return map;
	}

}
