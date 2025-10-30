package com.portfolio.service;

import java.util.List;

import com.portfolio.entity.Projects;
import com.portfolio.response.dto.ProjectResponseDto;

public interface ProjectsService {
	
	public boolean addProject(Projects project);
	
	public boolean updateProject(int id, Projects project);
	
	public List<ProjectResponseDto> getProjectsByOrganisationId(int organisationId);
	
	public List<ProjectResponseDto> getAllProjects();
	
	public boolean deleteProject(int id);

}
