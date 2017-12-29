package com.summer.shopping.spring.boot;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages= {"com.summer.shopping.persistence"})
@EnableJpaRepositories(basePackages = "com.summer.shopping.admin.dao")
@EnableTransactionManagement
public class JPAConfig {}
