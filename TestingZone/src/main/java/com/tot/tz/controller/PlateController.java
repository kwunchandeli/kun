package com.tot.tz.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.tot.tz.entity.Article;
import com.tot.tz.entity.Plate;
import com.tot.tz.entity.User;
import com.tot.tz.service.ArticleService;
import com.tot.tz.service.PlateService;
import com.tot.tz.service.UserService;
import com.tot.tz.util.IpUtil;

@Controller
@SessionAttributes({"username","pList","hotArticleList"})
public class PlateController {
	
	private static Logger logger = LogManager.getLogger(PlateController.class.getName());
	
	@Resource
	private UserService userService;
	
	@Resource
	private PlateService plateService;
	
	@Resource
	private ArticleService articleService;
	
	@GetMapping("/main/{page}")
	public String mainPage( @PathVariable int page,HttpServletRequest request,Model model){
		String ip = IpUtil.getIpAddr(request);
		logger.info("访问地址:"+ip);  
		logger.info("访问地址:"+page);  
		String username = userService.getUsernameByIp(ip);
		List<Plate> pList = plateService.getPlateList();
		List<Article> hotArticleList = articleService.getHotArticles();
		model.addAttribute("username", username);
		model.addAttribute("pList", pList);
		model.addAttribute("hotArticleList", hotArticleList);
		return "main";
	}
	
	@GetMapping("/plate/{plate}/{page}")
	public String plateContent(@PathVariable String plate,@PathVariable int page,Model model){
		return "main";
	}
	
	@GetMapping("/article/{article}")
	public String articleContent(@PathVariable String article, Model model){
		 model.addAttribute("article_name", "在CentOS下搭建自己的Git服务器");
		return "article";
	}
}
