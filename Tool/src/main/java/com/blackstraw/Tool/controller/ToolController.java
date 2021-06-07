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
import com.blackstraw.Tool.model.Tool;
import com.blackstraw.Tool.service.ToolService;

@RestController
@RequestMapping("/tool")
public class ToolController {
	
	Logger logger=LoggerFactory.getLogger(ToolController.class);
	
	@Autowired
	private ToolService toolService;
	
	
	@PostMapping
	public ResponseEntity<ToolResponseDTO> save(@RequestBody Tool tool) {
		ToolResponseDTO responseDTO=null;
		try {
			Tool tool1=toolService.save(tool);
			responseDTO=prepareResponse(tool1);
			return new ResponseEntity<ToolResponseDTO>(responseDTO,HttpStatus.OK);
		}catch (Exception e){
			logger.error("error while converting tool to dto",e,tool);
			return new ResponseEntity<ToolResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllTools")
	public ResponseEntity<List<ToolResponseDTO>> getAll(){
		List<ToolResponseDTO> responseDTOList=new ArrayList<ToolResponseDTO>();
		try {
			List<Tool> toolList=toolService.getAllTools();
			for(Tool tool1: toolList) {
				try {
					responseDTOList.add(prepareResponse(tool1));
				}catch(Exception e) {
					logger.error("error occured while converting tool to dto",e,tool1);
					
				}
			} logger.info("Tool to response dto conversion completed");
					return new ResponseEntity<List<ToolResponseDTO>>(responseDTOList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<ToolResponseDTO>>(responseDTOList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
	public ResponseEntity<ToolResponseDTO> findById(@PathVariable("id") int id) {
		ToolResponseDTO responseDTO=null;
		try {
			Tool tool1=toolService.findById(id);
			responseDTO=prepareResponse(tool1);
			return new ResponseEntity<ToolResponseDTO>(responseDTO, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<ToolResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("gettools/{name}")
	public ResponseEntity<ToolResponseDTO> findByName(@PathVariable("name") String name) {
		ToolResponseDTO responseDTO=null;
		try {
			Tool tool1=toolService.findByName(name);
			responseDTO=prepareResponse(tool1);
			return new ResponseEntity<ToolResponseDTO>(responseDTO,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<ToolResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	private ToolResponseDTO prepareResponse(Tool tool) {
		ToolResponseDTO responseDTO=new ToolResponseDTO();
		responseDTO.setId(tool.getId());
		responseDTO.setName(tool.getName());
		responseDTO.setVersion(tool.getVersion());
		return responseDTO;
	}
	

}
