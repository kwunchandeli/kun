package com.tot.tz.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.json.Json;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.tot.tz.entity.Article;
import com.tot.tz.entity.Plate;
import com.tot.tz.entity.User;
import com.tot.tz.service.ArticleService;
import com.tot.tz.service.PlateService;
import com.tot.tz.service.UserService;;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestLog {

	private static Logger logger = LogManager.getLogger(TestLog.class.getName());
	
	
	@Resource  
    private UserService userService = null;
	@Resource 
	private PlateService plateService;
	@Resource 
	private ArticleService articleService;
	
	@Test
	public void log(){
		// 记录debug级别的信息  
        logger.debug("This is debug message.");  
        // 记录info级别的信息  
        logger.info("This is info message.");  
        // 记录error级别的信息  
        logger.error("This is error message."); 
	}
	
	@Test  
    public void test1() {  
        User user = userService.getUserByIp("168.168.68.88");  
        logger.info("值："+user.getU_name());  
    }  
	
	@Test  
    public void test2() {  
        List<Plate> pList = plateService.getPlateList();
        logger.info(JSON.toJSONString(pList));  
    }
	
	@Test  
    public void test3() {  
		List<Article> aList = articleService.getHotArticles();
        logger.info(JSON.toJSONString(aList));  
    }
	
	@Test  
    public void test4() {  
		Map<String, Object> map = articleService.getPagingArticles(0, 10, 4);
        logger.info(JSON.toJSONString(map));  
    }
	
	@Test  
    public void test5() {  
		Article a = articleService.getArticleById(1);
        logger.info(JSON.toJSONString(a));  
    }
	
	@Test  
    public void test6() {  
		
		for(int i=0;i<10;i++){
			String aString = UUID.randomUUID().toString();
			System.out.println(aString);
		}
    }
	
	@Test  
    public void test7() {  
		
    }
}
