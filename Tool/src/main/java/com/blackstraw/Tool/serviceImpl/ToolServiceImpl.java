package com.blackstraw.Tool.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blackstraw.Tool.dto.ToolResponseDTO;
import com.blackstraw.Tool.globalExceptionHandler.NameMismatch;
import com.blackstraw.Tool.globalExceptionHandler.VersionMismatch;
import com.blackstraw.Tool.model.Tool;
import com.blackstraw.Tool.repository.ToolRepository;
import com.blackstraw.Tool.service.ToolService;

import ch.qos.logback.classic.Logger;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Log
@Log4j
@Service
public class ToolServiceImpl implements ToolService {
	
	@Autowired(required = true)
	private ToolRepository toolRepository;

	@Override
	public Tool save(Tool tool) {
		return toolRepository.save(tool);
		
	}

	@Override
	public Tool update(Tool tool) {
		return toolRepository.save(tool);
	}

	@Override
	public void delete(int id) {
		Tool tool=findById(id);
		if(tool!=null) {
			toolRepository.delete(tool);
		}
	}

	@Override
	public List<Tool> getAllTools() {
		return toolRepository.findAll();
	}

	@Override
	public Tool findById(int id) {
		Optional<Tool> isTool=toolRepository.findById(id);
		Tool tool=null;
		if(isTool.isPresent()) {
			tool=isTool.get();
		}
		return tool;
	}

	@Override
	public ResponseEntity<?> findByName(String name) {
		ToolResponseDTO responseDTO=null;
		try {
			Tool tools=toolRepository.findByName(name);
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

	@Override
	public ResponseEntity<?> findByVersion(String version) {
		ToolResponseDTO responseDTO=null;
		try {
			Tool tools=toolRepository.findByVersion(version);
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
