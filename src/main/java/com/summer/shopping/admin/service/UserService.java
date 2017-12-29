package com.summer.shopping.admin.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.summer.shopping.admin.dao.UserDao;
import com.summer.shopping.persistence.User;

@Service
public class UserService {
	@Autowired
	@Qualifier("UserDao")
	private UserDao userDao;
	
	public void createUser(User user) {
		userDao.save(user);	
	}
	
	public User getUserByEmail(String email) {
		if(StringUtils.isBlank(email)) {
			return null;
		}
		return userDao.getUserByEmail(email);
	}
	
}
