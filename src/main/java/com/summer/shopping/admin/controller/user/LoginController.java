package com.summer.shopping.admin.controller.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.summer.shopping.admin.service.UserService;
import com.summer.shopping.persistence.User;
import com.summer.shopping.utils.PasswordUtil;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginPage")
	public String index() {
	    return "authentication/loginPage";
	}
	
	@PostMapping("/login")	
	public String login(@RequestParam("email") String email,
			 @RequestParam("password") String password,
			 Model model) {
		if (StringUtils.isBlank(email)
				|| StringUtils.isBlank(password)) {
			return "authentication/validationError";
		}
				
	    User userFromDb = userService.getUserByEmail(email);
	    if(userFromDb == null) {
	    	    return "authentication/validationError";
	    }
	    
	    if(PasswordUtil.validatePassword(password, userFromDb.getPassword())) {
	        	return "authentication/success";
	    } else {
	      	return "authentication/validationError";
	    }
	 }
}
