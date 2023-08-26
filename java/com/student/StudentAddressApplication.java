package com.student;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.student.config.JwtFilter;


@SpringBootApplication
public class StudentAddressApplication {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean= new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StudentAddressApplication.class, args);
		System.out.println("Student Application is running..");
	}

}
