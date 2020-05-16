package com.ikasoa.web.mvc.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 抽象控制器
 * 
 * @author <a href="mailto:larry7696@gmail.com">Larry</a>
 * @version 0.0.1
 */
@Slf4j
public abstract class AbstractController {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Response<Integer> exp(Exception e) {
		log.error("error ! message: {}", e.getMessage());
		e.printStackTrace();
		return new Response<Integer>(1, e.getMessage(), 0);
	}

	private void initHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Allow-Credentials", "true");
	}

	protected void setHeader(HttpServletResponse response) {
		initHeader(response);
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setHeader("Allow", "GET,POST");
	}

	protected void setGetHeader(HttpServletResponse response) {
		initHeader(response);
		response.setHeader("Access-Control-Allow-Methods", "GET");
		response.setHeader("Allow", "GET");
	}

	protected void setPostHeader(HttpServletResponse response) {
		initHeader(response);
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Allow", "POST");
	}

}
