package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Experience;

@Repository
public interface ExperienceDAO extends JpaRepository<Experience, Integer>{

}
