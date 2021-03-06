package com.blackstraw.Tool.globalExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	
	@ExceptionHandler(value=IdNotMatch.class)
	public ResponseEntity<ExceptionModel> catchIdNotMatch(IdNotMatch idNotMatch){
		logger.error("Id didn't match");
		ExceptionModel exceptionModel=new ExceptionModel();
		exceptionModel.setE(idNotMatch);
		exceptionModel.setMsg("Id didn't match, please enter proper id");
		
		return new ResponseEntity<ExceptionModel>(exceptionModel,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value=NameMismatch.class)
	public ResponseEntity<ExceptionModel> catchnameMismatch(NameMismatch nameMismatch){
		logger.error("Name didn't match");
		ExceptionModel exceptionModel=new ExceptionModel();
		exceptionModel.setE(nameMismatch);
		exceptionModel.setMsg("Name didn't match, please enter proper name");
		
		return new ResponseEntity<ExceptionModel>(exceptionModel,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=VersionMismatch.class)
	public ResponseEntity<ExceptionModel> catchversionMismatch(VersionMismatch versionMismatch){
		logger.error("Version not found match");
		ExceptionModel exceptionModel=new ExceptionModel();
		exceptionModel.setE(versionMismatch);
		exceptionModel.setMsg("Version not found, please enter proper version");
		
		return new ResponseEntity<ExceptionModel>(exceptionModel,HttpStatus.BAD_REQUEST);
	}
}
