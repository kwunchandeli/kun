package com.tot.tz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlateController {
	
	
	@GetMapping("/main.do")
	public String test( Model model){
		 model.addAttribute("username", "测试用户");
		return "main";
	}
	
}
