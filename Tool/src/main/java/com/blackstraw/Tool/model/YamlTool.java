package com.blackstraw.Tool.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.catalina.mapper.Mapper;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlTool {
	
	public void yamlFileToMap() throws FileNotFoundException{
		Yaml yaml=new Yaml();
		String path=".\\src\\main\\resources\\application.yml";
		Map<String, String> map=yaml.load(new FileInputStream(new File(path)));
		System.out.println(map);
	}

	public static void main(String[] args) throws IOException {
		
		YamlTool obj=new YamlTool();
		obj.yamlFileToMap();
	
		
	}

}
