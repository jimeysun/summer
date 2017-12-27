package com.summer.shopping.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication(scanBasePackages= {"com.summer.shopping"})
@ServletComponentScan(basePackages = {
		"com.summer.shopping.spring.servlet",
		"com.summer.shopping.spring.filter",
		"com.summer.shopping.spring.listener"
})
public class MainAppBoot {

	public static void main(String[] args) {
	      SpringApplication.run(MainAppBoot.class, args);
	   }
}
