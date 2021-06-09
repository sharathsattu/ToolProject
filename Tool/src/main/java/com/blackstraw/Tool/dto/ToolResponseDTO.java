package com.blackstraw.Tool.dto;

public class ToolResponseDTO {
	
	private int id;
	private String name;
	private String version;
	private String config;
	
	public ToolResponseDTO() {
		
	}
	
	
	
	public ToolResponseDTO(int id, String name, String config, String version) {
		super();
		this.id = id;
		this.name = name;
		this.config = config;
		this.version = version;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	
	
	

	
	

}
