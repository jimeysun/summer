package com.summer.shopping.admin.controller.home;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableAutoConfiguration
public class HomePageController {
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}

}
