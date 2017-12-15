package com.tot.tz.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.tot.tz.config.Config;
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
@SessionAttributes("user")
public class FileUploadController {

	@Resource
	private Config config;
	
	private static Logger logger = LogManager
			.getLogger(FileUploadController.class.getName());

	@PostMapping("/upload/image")
	@ResponseBody
	public Map<String, Object> save(@ModelAttribute("user") User user,@RequestParam("imgFile") MultipartFile file) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (file != null) {
			String dir=config.UPLOADDIR + "images/" + user.getU_id() + "/";
			String type = null;// 文件类型
			String newFileName = "";
			String fileName = file.getOriginalFilename();// 文件原名称
			String imageTypeString ="bmp,jpg,jpeg,png,tiff,gif,pcx,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw,wmf";
			// 判断文件类型
			type = fileName.indexOf(".") != -1 ? fileName.substring(
					fileName.lastIndexOf(".") + 1, fileName.length()) : null;
					
			if(type!=null&&imageTypeString.indexOf(type.toLowerCase())>-1){
				//新文件名，添加原始文件名后缀
				newFileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + type;
				File dFile = new File(dir);
				if(!dFile.exists()){
					dFile.mkdir();
				}
				//创建新文件，路径为：图片服务器路径+用户ID+新文件名  
		         File newFile = new File(dir + newFileName);
		       //将内存中的数据写入磁盘  
		         try {
					file.transferTo(newFile);
				} catch (Exception e) {
					logger.error("保存文件错误！错误信息：" + e.getMessage());
					e.printStackTrace();
				} 
			}else{
				map.put("error", 1);
				map.put("message", "不支持的图片格式！支持的图片格式有"+imageTypeString);
			}
			map.put("error", 0);
			map.put("url", "/image/" + user.getU_id() + "/" + newFileName);
		} else {
			map.put("error", 1);
			map.put("message", "上传文件不能为空！");
		}

		return map;
	}

}
