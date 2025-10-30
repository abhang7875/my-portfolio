package com.portfolio.response.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CategoryResponseDto {

	private int id;
	
	private String name;
	
	private List<SkillsResponseDto> skills = new ArrayList<>();
	
}
