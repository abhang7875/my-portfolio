package com.portfolio.request.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
public class EducationRequestDto {
	
	@NotNull
	private String organisation;
	
	@NotNull
	private String degree;
	
	@NotNull
	private String from;
	
	@NotNull
	private String to;
}
