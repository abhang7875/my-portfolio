package com.portfolio.request.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SocialMediaProfilesRequestDto {
	
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String url;
	
	@NotNull
	private MultipartFile image;
	
	
}
