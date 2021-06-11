package com.blackstraw.Tool.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class ExecutionTimeInterceptor implements HandlerInterceptor {
	
	Logger logger=LoggerFactory.getLogger(ExecutionTimeInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle method");
		logger.info("RequestURL :"+request.getRequestURI());
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		logger.info("postHandle method");
		logger.info("RequestURL :"+request.getRequestURI());
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		logger.info("afterCompletion method");
		logger.info("RequestURL :"+request.getRequestURI());
		long executedTime=System.currentTimeMillis()-(long) request.getAttribute("startTime");
		logger.info(" Executed time in ms {}", executedTime);
	}

}
