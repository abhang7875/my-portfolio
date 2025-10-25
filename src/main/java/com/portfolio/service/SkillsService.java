package com.portfolio.service;

import java.util.List;

import com.portfolio.entity.Skill;
import com.portfolio.response.dto.SkillsResponseDto;

public interface SkillsService {
	
	public Skill addSkill(String skillName, int categoryId);
	
	public Skill updateSkill(int id, String newName, int newCategoryId);
	
	public boolean deleteSkill(int id);
	
	public List<SkillsResponseDto> getAllSkills();
	
	public List<Skill> getSkillsByCategory(int categoryId);
	
}
