package com.portfolio.service;

import java.util.List;

import com.portfolio.request.dto.ExperienceRequestDto;
import com.portfolio.response.dto.ExperienceResponseDto;

public interface ExperienceService {

	public boolean addExperience(ExperienceRequestDto dto);

	public boolean updateExperience(int id, ExperienceRequestDto dto);

	public boolean deleteExperience(int id);

	public List<ExperienceResponseDto> getAllExperiences();

}
