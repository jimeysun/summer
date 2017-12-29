package com.summer.shopping.admin.controller.user;

import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.summer.shopping.admin.service.UserService;
import com.summer.shopping.persistence.User;
import com.summer.shopping.persistence.UserRoleType;
import com.summer.shopping.utils.IdUtils;
import com.summer.shopping.utils.PasswordUtil;

@Controller
public class UserAddController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/newUserPage")
	public String index() {
	    return "authentication/createUser";
	}
	
	@PostMapping("/createUser")	
	 public String sayHello(@RequestParam("name") String name,
			 @RequestParam("email") String email,
			 @RequestParam("password") String password,
			 Model model) {
		if (StringUtils.isBlank(name)
				|| StringUtils.isBlank(email)
				|| StringUtils.isBlank(password)) {
			return "authentication/validationError";
		}
		
		
	    User user = new User();
	    user.setEmail(email);
	    user.setName(name);
	    user.setPassword(PasswordUtil.encrypt(password));
	    user.setDisabled(true);
	    user.setId(IdUtils.generateId());
	    user.setRole(UserRoleType.CUSTOMER.toString());
	    user.setCreate_time(new Timestamp(System.currentTimeMillis()));
	    userService.createUser(user);
	    		
	    return "authentication/success";
	 }
}
