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
	
	Logger logger=LoggerFactory.getLogger(ToolController.class);
	
	@Autowired
	private ToolService toolService;
	
	
	@PostMapping
	public ResponseEntity<ToolResponseDTO> save(@RequestBody Tool tool) {
		ToolResponseDTO responseDTO=null;
		try {
			Tool tools=toolService.save(tool);
			responseDTO=prepareResponse(tools);
			return new ResponseEntity<ToolResponseDTO>(responseDTO,HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<ToolResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllTools")
	public ResponseEntity<List<ToolResponseDTO>> getAll(){
		List<ToolResponseDTO> responseDTOList=new ArrayList<ToolResponseDTO>();
		try {
			List<Tool> toolList=toolService.getAllTools();
			for(Tool tools: toolList) {
				try {
					responseDTOList.add(prepareResponse(tools));
				}catch(Exception e) {
					logger.error("error in getting all the tools",e,tools);
				}
			} logger.info("All the tools retrieved");
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
	public ResponseEntity<?> findById(@PathVariable("id") int id)  {
		ToolResponseDTO responseDTO=null;
		try {
			Tool tools=toolService.findById(id);
			if(tools==null) {
				throw new IdNotMatch(" Please enter proper id");
			}else {
				responseDTO=prepareResponse(tools);
				return new ResponseEntity<ToolResponseDTO>(responseDTO, HttpStatus.FOUND);
			}
			
		}catch(IdNotMatch e) {
			String s="Id did't match";
			return new ResponseEntity<String>(s, HttpStatus.NOT_FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<ToolResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("gettools/{name}")
	public ResponseEntity<?> findByName(@PathVariable("name") String name) {
		ToolResponseDTO responseDTO=null;
		try {
			Tool tools=toolService.findByName(name);
			if(tools==null) {
				throw new NameMismatch("Please enter proper name");
			}else {
				responseDTO=prepareResponse(tools);
				return new ResponseEntity<ToolResponseDTO>(responseDTO,HttpStatus.OK);
			}
		}catch (NameMismatch e) {
			String s="Name didn't match";
			return new ResponseEntity<String>(s, HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<ToolResponseDTO>(responseDTO, HttpStatus.NO_CONTENT);
		}
		
	}
	
	
	@GetMapping("getversion/{version}")
	public ResponseEntity<?> findByVersion(@PathVariable("version") String version){
		ToolResponseDTO responseDTO=null;
		try {
			Tool tools=toolService.findByVersion(version);
			if(tools==null) {
				throw new VersionMismatch(" entered version not found ");
			}else {
				responseDTO=prepareResponse(tools);
				return new ResponseEntity<ToolResponseDTO>(responseDTO, HttpStatus.OK);
			}
		}
			catch(VersionMismatch e) {
				String s="There's a mismatch in your requested version, please enter proper version";
				return new ResponseEntity<String>(s, HttpStatus.NOT_FOUND);
			}catch(Exception e) {
				return new ResponseEntity<ToolResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
			
		}
	}
	
	
	private ToolResponseDTO prepareResponse(Tool tool) {
		ToolResponseDTO responseDTO=new ToolResponseDTO();
		responseDTO.setId(tool.getId());
		responseDTO.setName(tool.getName());
		responseDTO.setVersion(tool.getVersion());
		responseDTO.setConfig(tool.getConfig());
		return responseDTO;
	}
	

}
