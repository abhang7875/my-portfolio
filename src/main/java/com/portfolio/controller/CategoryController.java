package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.Category;
import com.portfolio.response.dto.CategoryResponseDto;
import com.portfolio.service.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestParam String name) {
        Category category = categoryService.addCategory(name);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestParam String name) {
        Category category = categoryService.updateCategory(id, name);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        if (categoryService.deleteCategory(id)) {
            return ResponseEntity.ok("Category deleted successfully");
        }
        return ResponseEntity.badRequest().body("Category not found");
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
}
