package com.blackstraw.Tool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Tool> getAll(){
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
	

}
