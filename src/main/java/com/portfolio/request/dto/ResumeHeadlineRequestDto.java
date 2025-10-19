package com.portfolio.request.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResumeHeadlineRequestDto {
	
	@NotNull
	private String headLine;

}
