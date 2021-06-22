package com.fileupload.FileUpload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedWebappClassLoader;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FileUploadApplication {
	
	private int maxUploadSizeInMb= 10* 1024*1024;

	public static void main(String[] args) {
		SpringApplication.run(FileUploadApplication.class, args);
	}
	


}
