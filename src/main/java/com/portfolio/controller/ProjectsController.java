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

import com.portfolio.entity.Projects;
import com.portfolio.service.ProjectsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectsController {
	
	@Autowired
	ProjectsService projectService;
	
	@PostMapping("/addProject")
	public ResponseEntity<String> addProject(@RequestBody Projects project) {
		if(projectService.addProject(project)) {
			return ResponseEntity.ok("Successfull");
		}
		return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/updateProject/{id}")
	public ResponseEntity<String> updateProject(@PathVariable("id") int id, @RequestBody Projects project) {
		if(projectService.updateProject(id, project)) {
			return ResponseEntity.ok("Successfull");
		}
		return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getAllProjects")
	public List<Projects> getAllProjects() {
		return projectService.getAllProjects();
	}
	
	@GetMapping("/getProjectsById/{id}")
	public List<Projects> getProjectsById(@PathVariable("id") int id) {
		return projectService.getProjectsByOrganisationId(id);
	}
	
	@DeleteMapping("/deletePrjectById/{id}")
	public ResponseEntity<String> deleteProject(@PathVariable("id") int id) {
		if(projectService.deleteProject(id)) {
			return ResponseEntity.ok("Successfull");
		}
		return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
