package com.portfolio.response.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(content = JsonInclude.Include.NON_NULL)
public class ProjectResponseDto {
	
	private int id;
	
	private String name;
	
	private String from;
	
	private String to;
	
	private String organisation;
	
	private List<String> description;
}
