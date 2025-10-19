package com.portfolio.service;

import java.util.List;

import com.portfolio.entity.SocialMediaProfiles;
import com.portfolio.request.dto.SocialMediaProfilesRequestDto;

public interface SocialMediaProfilesService {
	
	public boolean addSocialMediaProfile(SocialMediaProfilesRequestDto dto);
	
	public List<SocialMediaProfiles> getAllProfiles();
	
	public boolean updateSocialMediaProfile(SocialMediaProfilesRequestDto dto);
	
	public boolean deleteProfile(int profileId);

}
