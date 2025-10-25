package com.portfolio.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.entity.Experience;
import com.portfolio.entity.Responsibilities;
import com.portfolio.repository.ExperienceDAO;
import com.portfolio.request.dto.ExperienceRequestDto;
import com.portfolio.response.dto.ExperienceResponseDto;
import com.portfolio.service.ExperienceService;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceDAO experienceManager;

	@Override
	public boolean addExperience(ExperienceRequestDto dto) {
		try {
			Experience experience = mapToEntity(dto);
			experienceManager.save(experience);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateExperience(int id, ExperienceRequestDto dto) {
		try {
			Experience experience = mapToEntity(dto);
			experience.setId(id);
			experienceManager.save(experience);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteExperience(int id) {
		Optional<Experience> experience = experienceManager.findById(id);
		if (experience.isEmpty())
			return false;
		experienceManager.deleteById(id);
		return true;
	}

	@Override
	public List<ExperienceResponseDto> getAllExperiences() {
		List<Experience> experiences = experienceManager.findAll();
		return experiences.stream().map((experience) -> {
			ExperienceResponseDto dto = new ExperienceResponseDto();
			dto.setId(experience.getId());
			dto.setClient(experience.getClient());
			dto.setDesignation(experience.getDesignation());
			dto.setFrom(experience.getFrom());
			dto.setTo(experience.getTo());
			List<String> responbilities = experience.getResponsibilities().stream().map(ele -> ele.getResponsibility())
					.collect(Collectors.toList());
			dto.setResponsibilities(responbilities);
			return dto;
		}).collect(Collectors.toList());
	}

	private Experience mapToEntity(ExperienceRequestDto dto) {
		Experience experience = new Experience();
		experience.setDesignation(dto.getDesignation());
		experience.setClient(dto.getClient());
		experience.setFrom(dto.getFrom());
		experience.setTo(dto.getTo());

		List<Responsibilities> responsibilities = dto.getResponsibilities().stream().map(r -> {
			Responsibilities res = new Responsibilities();
			res.setResponsibility(r);
			res.setExperience(experience); // link back to parent
			return res;
		}).collect(Collectors.toList());

		experience.setResponsibilities(responsibilities);
		return experience;
	}

}
