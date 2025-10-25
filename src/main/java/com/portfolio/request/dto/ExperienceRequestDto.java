package com.portfolio.request.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExperienceRequestDto {
	
	@NotNull
	private String designation;
	
	@NotNull
	private String client;

	@NotNull
	private String from;
	
	@NotNull
	private String to;
	
	@NotNull
	private List<String> responsibilities;
	
}
