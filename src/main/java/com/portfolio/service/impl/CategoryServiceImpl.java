package com.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.entity.Category;
import com.portfolio.entity.Skill;
import com.portfolio.repository.CategoryDAO;
import com.portfolio.response.dto.CategoryResponseDto;
import com.portfolio.response.dto.SkillsResponseDto;
import com.portfolio.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryRepository;

    @Override
    public Category addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(int id, String name) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
        existing.setName(name);
        return categoryRepository.save(existing);
    }

    @Override
    public boolean deleteCategory(int id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        List<Category> data =  categoryRepository.findAll();
        List<CategoryResponseDto> output = new ArrayList<>();
        for(Category category: data) {
        	CategoryResponseDto response = new CategoryResponseDto();
            response.setId(category.getId());
            response.setName(category.getName());
            List<Skill> skills = category.getSkills();
            for(Skill skill: skills) {
            	if(response.getSkills() == null) {
            		response.setSkills(new ArrayList<>());
            	}
            	SkillsResponseDto skillDto = new SkillsResponseDto();
            	skillDto.setName(skill.getName());
            	skillDto.setId(skill.getId());
            	skillDto.setCategory(skill.getCategory().getName());
            	response.getSkills().add(skillDto);
            }
            output.add(response);
        }
        return output;
    }

    @Override
    public CategoryResponseDto getCategoryById(int id) {
        Optional<Category> category =  categoryRepository.findById(id);
        if(category.isEmpty()) return null;
        
        CategoryResponseDto response = new CategoryResponseDto();
        response.setId(category.get().getId());
        response.setName(category.get().getName());
        List<Skill> skills = category.get().getSkills();
        for(Skill skill: skills) {
        	if(response.getSkills() == null) {
        		response.setSkills(new ArrayList<>());
        	}
        	SkillsResponseDto skillDto = new SkillsResponseDto();
        	skillDto.setName(skill.getName());
        	skillDto.setId(skill.getId());
        	skillDto.setCategory(skill.getCategory().getName());
        	response.getSkills().add(skillDto);
        }
        return response;
    }
}
