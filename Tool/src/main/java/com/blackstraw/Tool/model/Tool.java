package com.blackstraw.Tool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tool")
public class Tool {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String version;
	
	
	public Tool() {
		super();
	}


	public Tool(int id, String name, String version) {
		super();
		this.id = id;
		this.name = name;
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
	
	
	
	
	
	

}
