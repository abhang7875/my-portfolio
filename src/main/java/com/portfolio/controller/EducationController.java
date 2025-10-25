package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.request.dto.EducationRequestDto;
import com.portfolio.response.dto.EducationResponseDto;
import com.portfolio.service.EducationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EducationController {
	
	@Autowired
	EducationService educationService;
	
	@PostMapping("/addEducation")
	public ResponseEntity<String> addEducation(@RequestBody EducationRequestDto dto) {
		if(educationService.addEducation(dto)) {
			return ResponseEntity.ok("Successful");
		}
		return new ResponseEntity<String>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/updateEducation/{id}")
	public ResponseEntity<String> updateEducation(@PathVariable("id") int id, @RequestBody EducationRequestDto dto) {
		if(educationService.updateEducation(id, dto)) {
			return ResponseEntity.ok("Successful");
		}
		return new ResponseEntity<String>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getAllEducations")
	public List<EducationResponseDto> getAllEducations() {
		return educationService.getAllEducations();
	}
	
	@DeleteMapping("/deleteEducation/{id}")
	public ResponseEntity<String> deleteEducation(@PathVariable("id") int id) {
		if(educationService.deleteEducation(id)) {
			return ResponseEntity.ok("Successful");
		}
		return new ResponseEntity<String>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
