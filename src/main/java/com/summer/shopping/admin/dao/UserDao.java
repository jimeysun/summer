package com.summer.shopping.admin.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.summer.shopping.persistence.User;

@Repository
@Qualifier("UserDao")
public interface UserDao extends CrudRepository<User, String> {

	@Query("from User as u where u.email = :email")
	User getUserByEmail(@Param("email") String email);
	
	@Query("from User as u where u.name = :name")
	User getUserByName(@Param("name") String name);
}
