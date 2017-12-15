package com.tot.tz.Interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tot.tz.controller.FileUploadController;
import com.tot.tz.entity.User;
import com.tot.tz.service.ArticleService;
import com.tot.tz.service.PlateService;
import com.tot.tz.service.StatisticsService;
import com.tot.tz.service.UserService;
import com.tot.tz.web.InitSessionAttribute;

public class InitSessionInterceptor extends HandlerInterceptorAdapter {
	
	private static Logger logger = LogManager
			.getLogger(InitSessionInterceptor.class.getName());
	
	@Resource
	private InitSessionAttribute initSessionAttribute;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		initSessionAttribute.setSessionAttr(request,response);
		return true;
	}
	
}
