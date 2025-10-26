package com.portfolio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.entity.Projects;
import com.portfolio.repository.ProjectDAO;
import com.portfolio.service.ProjectsService;

@Service
public class ProjectsServiceImpl implements ProjectsService{
	
	@Autowired
	ProjectDAO projectsManager;
	
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
	public List<Projects> getProjectsByOrganisationId(int organisationId) {
		return projectsManager.findByOrganisationId(organisationId);
	}

	@Override
	public List<Projects> getAllProjects() {
		return projectsManager.findAll();
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
	
}
