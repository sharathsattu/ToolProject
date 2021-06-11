package com.blackstraw.Tool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name="tool")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tool {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String version;
	private String config;
	

}
