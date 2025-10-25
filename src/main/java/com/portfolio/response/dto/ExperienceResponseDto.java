package com.portfolio.response.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExperienceResponseDto {
	
	private int id;
	
	private String designation;
	
	private String client;

	private String from;
	
	private String to;
	
	private List<String> responsibilities;
	
}
