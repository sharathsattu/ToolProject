package com.blackstraw.Tool.globalExceptionHandler;

import org.springframework.http.HttpStatus;

public class ExceptionModel {
	
	private HttpStatus status;
	private String msg;
	private Exception e;
	
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Exception getE() {
		return e;
	}
	public void setE(Exception e) {
		this.e = e;
	}
	
	

}
