package com.tot.tz.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.tot.tz.controller.PlateController;
import com.tot.tz.entity.Article;
import com.tot.tz.entity.Plate;
import com.tot.tz.entity.User;
import com.tot.tz.service.ArticleService;
import com.tot.tz.service.PlateService;
import com.tot.tz.service.StatisticsService;
import com.tot.tz.service.UserService;
import com.tot.tz.util.IpUtil;

@Component
public class InitSessionAttribute {

	private static Logger logger = LogManager
			.getLogger(InitSessionAttribute.class.getName());

	@Resource
	private UserService userService;

	@Resource
	private PlateService plateService;

	@Resource
	private ArticleService articleService;

	@Resource
	private StatisticsService statisticsService;

	public InitSessionAttribute() {
		super();
	}

	public User setSessionAttr(HttpServletRequest request,
			HttpServletResponse response) {
		String ip = IpUtil.getIpAddr(request);
		logger.info("================访问地址:" + ip + "================");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null && session.getAttribute("pList") == null){
			logger.info("================首次访问，初始化数据================");
			user = userService.getUserByIp(ip);
			List<Plate> pList = plateService.getPlateList();
			List<Article> hotArticleList = articleService.getHotArticles();
			session.setAttribute("user", user);
			session.setAttribute("pList", pList);
			session.setAttribute("hotArticleList", hotArticleList);
			session.setAttribute("statistics", statisticsService.getStatistics());
		}
		return user;
	};

}
