package com.tot.tz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.tot.tz.dto.ArticleDto;
import com.tot.tz.entity.Article;
import com.tot.tz.entity.Plate;
import com.tot.tz.entity.User;
import com.tot.tz.service.ArticleService;
import com.tot.tz.service.PlateService;
import com.tot.tz.service.StatisticsService;
import com.tot.tz.service.UserService;
import com.tot.tz.util.IpUtil;

@Controller
@SessionAttributes({"username","user","pList","hotArticleList","statistics"})
public class PlateController {
	
	private static Logger logger = LogManager.getLogger(PlateController.class.getName());
	
	@Resource
	private UserService userService;
	
	@Resource
	private PlateService plateService;
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private StatisticsService statisticsService;
	
	@GetMapping("/main/{page}")
	public String mainPage( @PathVariable int page,HttpServletRequest request,Model model){
		String ip = IpUtil.getIpAddr(request);
		logger.info("访问地址:"+ip);  
		//String username = userService.getUsernameByIp(ip);
		User user = userService.getUserByIp(ip);
		List<Plate> pList = plateService.getPlateList();
		List<Article> hotArticleList = articleService.getHotArticles();
		Map<String, Object> contentMap = articleService.getPagingArticles(0, 10, page);
		//model.addAttribute("username", username);
		model.addAttribute("user", user);
		model.addAttribute("pList", pList);
		model.addAttribute("hotArticleList", hotArticleList);
		model.addAttribute("contentMap", contentMap);
		model.addAttribute("statistics", statisticsService.getStatistics());
		return "main";
	}
	
	@GetMapping("/plate/{plate}/{page}")
	public String plateContent(@PathVariable int plate,@PathVariable int page,Model model){
		Map<String, Object> contentMap = articleService.getPagingArticles(plate, 10, page);
		model.addAttribute("contentMap", contentMap);
		return "main";
	}
	
	@GetMapping("/article/{article_id}")
	public String articleContent(@ModelAttribute("user") User user,@PathVariable int article_id, Model model){
		Article article = articleService.updatePageView(article_id,user.getU_id());
		model.addAttribute("article",article);
		return "article";
	}
	
	@GetMapping("/article/edit/{article_id}")
	public String edit(@PathVariable int article_id,Model model){
		Article article = articleService.getArticleById(article_id);
		model.addAttribute("article",article);
		return "edit";
	}
	
	@PostMapping("/save/article")
	@ResponseBody
	public Map<String, Object> save(@ModelAttribute("user") User user,@RequestBody ArticleDto articleDto){
		articleDto.setU_id(user.getU_id());
		int id = articleService.saveOrUpdateArticle(articleDto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("status", 0);
		return map;
	}
	
	@GetMapping("/my/all/{page}")
	public String my(@ModelAttribute("user") User user,@PathVariable int page,Model model){
		Map<String, Object> myArticleMap = articleService.getMyPagingArticles(user.getU_id(), 10, page,"2");
		model.addAttribute("myArticleMap", myArticleMap);
		model.addAttribute("type", "2");
		return "my";
	}
	
	@GetMapping("/my/public/{page}")
	public String mypublic(@ModelAttribute("user") User user,@PathVariable int page,Model model){
		Map<String, Object> myArticleMap = articleService.getMyPagingArticles(user.getU_id(), 10, page,"1");
		model.addAttribute("myArticleMap", myArticleMap);
		model.addAttribute("type", "1");
		return "my";
	}
	
	@GetMapping("/my/nonpublic/{page}")
	public String nonpublic(@ModelAttribute("user") User user,@PathVariable int page,Model model){
		Map<String, Object> myArticleMap = articleService.getMyPagingArticles(user.getU_id(), 10, page,"0");
		model.addAttribute("myArticleMap", myArticleMap);
		model.addAttribute("type", "0");
		return "my";
	}
}
