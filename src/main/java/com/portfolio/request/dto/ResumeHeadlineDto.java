package com.portfolio.request.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResumeHeadlineDto {
	
	@NotNull
	private String headLine;

}
