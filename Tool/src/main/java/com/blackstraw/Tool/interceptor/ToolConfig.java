package com.blackstraw.Tool.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ToolConfig implements WebMvcConfigurer{
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(executionTimeInterceptor());
	}
	
	@Bean
	public ExecutionTimeInterceptor executionTimeInterceptor() {
		return new ExecutionTimeInterceptor();
	}

}
