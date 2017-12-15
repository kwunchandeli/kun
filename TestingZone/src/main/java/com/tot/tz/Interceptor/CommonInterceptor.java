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

public class CommonInterceptor extends HandlerInterceptorAdapter {
	
	private static Logger logger = LogManager
			.getLogger(CommonInterceptor.class.getName());
	
	@Resource
	private InitSessionAttribute initSessionAttribute;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		User user = initSessionAttribute.setSessionAttr(request,response);
		String requestURI = request.getRequestURI();
		if(user == null){
			//request.getRequestDispatcher("/main/1").forward(request, response);
			//访问需要查看权限更高级的权限时，用户若只有查看权限，则记录日志并重定向到主页
			logger.info("============未登记用户访问:" + requestURI + "=============");
			response.sendRedirect(request.getContextPath()+"/main/1");
			return false;
		}
		return true;
	}
	
}
