package com.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.entity.Education;
import com.portfolio.repository.EducationDAO;
import com.portfolio.request.dto.EducationRequestDto;
import com.portfolio.response.dto.EducationResponseDto;
import com.portfolio.service.EducationService;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationDAO educationManager;

	@Override
	public boolean addEducation(EducationRequestDto dto) {
		try {
			Education education = new Education();
			education.setOrganisation(dto.getOrganisation());
			education.setDegree(dto.getDegree());
			education.setFrom(dto.getFrom());
			education.setTo(dto.getTo());
			educationManager.save(education);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateEducation(int id, EducationRequestDto dto) {
		try {
			Optional<Education> records = educationManager.findById(id);
			if(records.isEmpty()) return false;
			
			Education education = records.get();
			education.setOrganisation(dto.getOrganisation());
			education.setDegree(dto.getDegree());
			education.setFrom(dto.getFrom());
			education.setTo(dto.getTo());
			educationManager.save(education);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteEducation(int id) {
		Optional<Education> records = educationManager.findById(id);
		if(records.isEmpty()) return false;
		educationManager.deleteById(id);
		return true;
	}

	@Override
	public List<EducationResponseDto> getAllEducations() {
		List<EducationResponseDto> output = new ArrayList<>();
		List<Education> educations = educationManager.findAll();
		
		for(Education entity: educations) {
			EducationResponseDto education = new EducationResponseDto();
			education.setId(entity.getId());
			education.setOrganisation(entity.getOrganisation());
			education.setDegree(entity.getDegree());
			education.setFrom(entity.getFrom());
			education.setTo(entity.getTo());
			output.add(education);
		}
		return output;
	}

}
