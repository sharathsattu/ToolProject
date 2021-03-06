package com.blackstraw.Tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.blackstraw.Tool.model.Tool;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Integer> {

	public Tool findByName(String name);

	public Tool findByVersion(String version);

	public void deleteById(ResponseEntity<?> tool);




}
