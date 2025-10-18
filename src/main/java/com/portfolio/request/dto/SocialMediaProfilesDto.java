package com.portfolio.request.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SocialMediaProfilesDto {
	
	@NotNull
	private String name;
	
	@NotNull
	private String url;
	
	@NotNull
	private MultipartFile image;
	
	
}
