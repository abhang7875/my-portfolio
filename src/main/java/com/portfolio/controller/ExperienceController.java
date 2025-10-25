package com.portfolio.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.portfolio.entity.Experience;
import com.portfolio.entity.Responsibilities;
import com.portfolio.request.dto.ExperienceRequestDto;
import com.portfolio.response.dto.ExperienceResponseDto;
import com.portfolio.service.ExperienceService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExperienceController {
	
	@Autowired
	ExperienceService expService;
	
	@PostMapping("/addExperience")
	public ResponseEntity<String> addExperience(@RequestBody ExperienceRequestDto dto) {
		if(expService.addExperience(dto)) {
			return ResponseEntity.ok("Successful");
		}
		return new ResponseEntity<String>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/updateExperience/{id}")
	public ResponseEntity<String> updateExperience(@PathVariable("id") int id, @RequestBody ExperienceRequestDto dto) {
		if(expService.updateExperience(id, dto)) {
			return ResponseEntity.ok("Successful");
		}
		return new ResponseEntity<String>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getAllExperiences")
	public List<ExperienceResponseDto> getAllExperiences() {
		return expService.getAllExperiences();
	}
	
	@DeleteMapping("/deleteExperience/{id}")
	public ResponseEntity<String> deleteExperience(@PathVariable("id") int id) {
		if(expService.deleteExperience(id)) {
			return ResponseEntity.ok("Successful");
		}
		return new ResponseEntity<String>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
