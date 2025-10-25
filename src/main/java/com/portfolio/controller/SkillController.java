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

import com.portfolio.entity.Skill;
import com.portfolio.response.dto.SkillsResponseDto;
import com.portfolio.service.SkillsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SkillController {

	@Autowired
	private SkillsService skillService;

	@PostMapping("/addSkill")
	public ResponseEntity<Skill> addSkill(@RequestParam String name, @RequestParam int categoryId) {
		Skill skill = skillService.addSkill(name, categoryId);
		return ResponseEntity.ok(skill);
	}

	@PutMapping("/updateSkill/{id}")
	public ResponseEntity<Skill> updateSkill(@PathVariable int id, @RequestParam String name,
			@RequestParam int categoryId) {
		Skill skill = skillService.updateSkill(id, name, categoryId);
		return ResponseEntity.ok(skill);
	}

	@DeleteMapping("/deleteSkill/{id}")
	public ResponseEntity<String> deleteSkill(@PathVariable int id) {
		if (skillService.deleteSkill(id)) {
			return ResponseEntity.ok("Skill deleted successfully");
		} else {
			return ResponseEntity.badRequest().body("Skill not found");
		}
	}

	@GetMapping("/getAllSkills")
	public ResponseEntity<List<SkillsResponseDto>> getAllSkills() {
		return ResponseEntity.ok(skillService.getAllSkills());
	}

	@GetMapping("/getSkillsByCategory/{categoryId}")
	public ResponseEntity<List<Skill>> getSkillsByCategory(@PathVariable int categoryId) {
		return ResponseEntity.ok(skillService.getSkillsByCategory(categoryId));
	}
}
