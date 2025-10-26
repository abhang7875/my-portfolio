package com.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Projects;

@Repository
public interface ProjectDAO extends JpaRepository<Projects, Integer>{
	
	List<Projects> findByOrganisationId(int organisationId);
	
}
