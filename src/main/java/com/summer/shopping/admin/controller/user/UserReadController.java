package com.summer.shopping.admin.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.summer.shopping.admin.service.UserService;
import com.summer.shopping.persistence.User;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/users")
public class UserReadController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/query")
	public ResponseEntity<User> get(@RequestParam("email") String email) {
	    User user = 	userService.getUserByEmail(email);
	    
	    return ResponseEntity.ok().body(user);
	}
	
}
