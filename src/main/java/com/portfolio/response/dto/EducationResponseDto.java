package com.portfolio.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
public class EducationResponseDto {
	
	@NotNull
	private int id;
	
	@NotNull
	private String organisation;
	
	@NotNull
	private String degree;
	
	@NotNull
	private String from;
	
	@NotNull
	private String to;
}
