package com.portfolio.service;

import java.util.List;

import com.portfolio.entity.Category;
import com.portfolio.response.dto.CategoryResponseDto;

public interface CategoryService {
	
	public Category addCategory(String name);
	
	public Category updateCategory(int id, String name);
	
	public boolean deleteCategory(int id);
	
	public List<CategoryResponseDto> getAllCategories();
	
	public CategoryResponseDto getCategoryById(int id);

}
