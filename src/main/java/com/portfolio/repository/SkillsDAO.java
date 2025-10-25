package com.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.entity.Skill;

public interface SkillsDAO extends JpaRepository<Skill, Integer> {
	List<Skill> findByCategoryId(int categoryId);
}
