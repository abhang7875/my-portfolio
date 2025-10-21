package com.portfolio.request.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CertificationRequestDto {
	
	@NotNull
	private String name;
	
	@NotNull
	private String description;
	
	private String issuedBy;
	
	private String issueDate;
	
	private int id;
	
	private MultipartFile logoImage;
	
	private MultipartFile certificateImage;
	
}
