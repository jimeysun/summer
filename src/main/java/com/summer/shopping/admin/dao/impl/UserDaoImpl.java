package com.summer.shopping.admin.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.summer.shopping.admin.dao.UserDao;
import com.summer.shopping.persistence.User;

@Repository
@Transactional
public class UserDaoImpl  {
	@PersistenceContext
	private EntityManager em;
	
	public void addUser(User user) {
		em.persist(user);
	}
	
	public User getUserByEmail(String email) {
		return em.createQuery("from User as u where u.email = :email", User.class)
		.setParameter("email", email)
		.getSingleResult();
	}

}
