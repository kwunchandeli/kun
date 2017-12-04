package com.tot.tz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@GetMapping("/test/{ownerId}.do")
	public String test(@PathVariable String ownerId, Model model){
		System.out.println(ownerId+"22");
		return ownerId;
	}
	
}
