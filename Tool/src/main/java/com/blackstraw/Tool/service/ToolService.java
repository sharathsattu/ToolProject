package com.blackstraw.Tool.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.blackstraw.Tool.dto.ToolResponseDTO;
import com.blackstraw.Tool.globalExceptionHandler.IdNotMatch;
import com.blackstraw.Tool.model.Tool;

public interface ToolService {
	
	public Tool save(Tool tool);
	public Tool update(Tool tool);
	public void delete(int id);
	public List<Tool> getAllTools();
	public Tool findById(int id);
		public ResponseEntity<?> findByName(String name);

	public ResponseEntity<?> findByVersion(String version);
}
