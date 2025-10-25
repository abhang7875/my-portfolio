package com.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.entity.Category;
import com.portfolio.entity.Skill;
import com.portfolio.repository.CategoryDAO;
import com.portfolio.repository.SkillsDAO;
import com.portfolio.response.dto.SkillsResponseDto;
import com.portfolio.service.SkillsService;

@Service
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    private SkillsDAO skillsManager;

    @Autowired
    private CategoryDAO categoryManager;

    @Override
    public Skill addSkill(String skillName, int categoryId) {
        Optional<Category> category = categoryManager.findById(categoryId);
        if (category.isEmpty()) {
            throw new RuntimeException("Category not found with ID: " + categoryId);
        }

        Skill skill = new Skill();
        skill.setName(skillName);
        skill.setCategory(category.get());
        return skillsManager.save(skill);
    }

    @Override
    public Skill updateSkill(int id, String newName, int newCategoryId) {
        Skill existingSkill = skillsManager.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        Category newCategory = categoryManager.findById(newCategoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existingSkill.setName(newName);
        existingSkill.setCategory(newCategory);
        return skillsManager.save(existingSkill);
    }

    @Override
    public boolean deleteSkill(int id) {
        if (skillsManager.existsById(id)) {
            skillsManager.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<SkillsResponseDto> getAllSkills() {
        List<Skill> data =  skillsManager.findAll();
        List<SkillsResponseDto> output = new ArrayList<>();
        
        for(Skill skill: data) {
        	SkillsResponseDto response = new SkillsResponseDto();
        	response.setId(skill.getId());
        	response.setName(skill.getName());
        	response.setCategory(skill.getCategory().getName());
        	output.add(response);
        }
        
        return output;
    }

    @Override
    public List<Skill> getSkillsByCategory(int categoryId) {
        return skillsManager.findByCategoryId(categoryId);
    }
}
