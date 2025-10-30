package com.portfolio.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.entity.Experience;
import com.portfolio.entity.Projects;
import com.portfolio.repository.ExperienceDAO;
import com.portfolio.repository.ProjectDAO;
import com.portfolio.response.dto.ProjectResponseDto;
import com.portfolio.service.ProjectsService;

@Service
public class ProjectsServiceImpl implements ProjectsService{
	
	@Autowired
	ProjectDAO projectsManager;
	
	@Autowired
	ExperienceDAO experienceManager;
	
	@Override
	public boolean addProject(Projects project) {
		try {
			projectsManager.save(project);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProject(int id, Projects project) {
		try {
			Optional<Projects> records = projectsManager.findById(id);
			if(records.isEmpty()) return false;
			project.setId(records.get().getId());
			projectsManager.save(project);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ProjectResponseDto> getProjectsByOrganisationId(int organisationId) {
		List<Projects> projects =  projectsManager.findByOrganisationId(organisationId);;
		return projects.stream().map((project) -> {
			ProjectResponseDto dto = new ProjectResponseDto();
			dto.setId(project.getId());
			dto.setName(project.getName());
			dto.setFrom(project.getFrom());
			dto.setTo(project.getTo());
			dto.setDescription(project.getDescription());
			dto.setOrganisation(name(project.getOrganisationId()));
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public List<ProjectResponseDto> getAllProjects() {
		List<Projects> projects =  projectsManager.findAll();
		return projects.stream().map((project) -> {
			ProjectResponseDto dto = new ProjectResponseDto();
			dto.setId(project.getId());
			dto.setName(project.getName());
			dto.setFrom(project.getFrom());
			dto.setTo(project.getTo());
			dto.setDescription(project.getDescription());
			dto.setOrganisation(name(project.getOrganisationId()));
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public boolean deleteProject(int id) {
		try {
			Optional<Projects> records = projectsManager.findById(id);
			if(records.isEmpty()) return false;
			projectsManager.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private String name(int organisationId) {
		Optional<Experience> entity = experienceManager.findById(organisationId);
		if(entity.isEmpty()) return null;
		return entity.get().getClient();
	}
	
}
