package com.fileupload.FileUpload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileUploadController {
	
	
	@RequestMapping(value="/upload", 
			method=RequestMethod.POST,
			consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	
	
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		File convertFile=new File("H:/fileupload/" + file.getOriginalFilename());
		convertFile.createNewFile();
		try (FileOutputStream fos=new FileOutputStream(convertFile)){
			fos.write(file.getBytes());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "File has uploaded successfully";
		
	}
	
	

}
