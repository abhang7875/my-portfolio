package com.portfolio.service;

import java.util.List;

import com.portfolio.request.dto.EducationRequestDto;
import com.portfolio.response.dto.EducationResponseDto;

public interface EducationService {
	public boolean addEducation(EducationRequestDto dto);
	
	public boolean updateEducation(int id, EducationRequestDto dto);
	
	public boolean deleteEducation(int id);
	
	public List<EducationResponseDto> getAllEducations();
}
