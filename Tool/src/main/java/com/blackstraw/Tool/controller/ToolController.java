package com.blackstraw.Tool.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blackstraw.Tool.dto.ToolResponseDTO;
import com.blackstraw.Tool.globalExceptionHandler.IdNotMatch;
import com.blackstraw.Tool.globalExceptionHandler.NameMismatch;
import com.blackstraw.Tool.globalExceptionHandler.VersionMismatch;
import com.blackstraw.Tool.model.Tool;
import com.blackstraw.Tool.service.ToolService;

@RestController
@RequestMapping("/tool")
public class ToolController {
	
	
	@Autowired
	private ToolService toolService;
	
	
	@PostMapping
	public Tool save(@RequestBody Tool tool) {
		 return toolService.save(tool);
	}
	
	@GetMapping("/getAllTools")
	public List<Tool> getAllTools(){
		return toolService.getAllTools();
				
	}
	
	@PutMapping
	public Tool update(@RequestBody Tool tool) {
		if(tool.getId()==0) {
			return null;
		}
		return toolService.update(tool);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") int id) {
		toolService.delete(id);
	}
	
	@GetMapping(value="/{id}")
	public Tool findById(@PathVariable("id") int id) {
		return toolService.findById(id);
	}
	
	@GetMapping("gettools/{name}")
	public ResponseEntity<?> findByName(@PathVariable("name") String name) {
		return toolService.findByName(name);
		
	}
	
	
	@GetMapping("getversion/{version}")
	public ResponseEntity<?> findByVersion(@PathVariable("version") String version){
		return toolService.findByVersion(version);
	}
	
	

	

}
