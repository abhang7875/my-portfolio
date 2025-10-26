package com.portfolio.service;

import java.util.List;

import com.portfolio.entity.Projects;

public interface ProjectsService {
	
	public boolean addProject(Projects project);
	
	public boolean updateProject(int id, Projects project);
	
	public List<Projects> getProjectsByOrganisationId(int organisationId);
	
	public List<Projects> getAllProjects();
	
	public boolean deleteProject(int id);

}
