package com.portfolio.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.entity.SocialMediaProfiles;
import com.portfolio.repository.SocialMediaProfilesDAO;
import com.portfolio.request.dto.SocialMediaProfilesRequestDto;
import com.portfolio.service.SocialMediaProfilesService;

@Service
public class SocialMediaProfilesServiceImpl implements SocialMediaProfilesService {

	@Autowired
	private SocialMediaProfilesDAO socialMediaManager;

	@Value("${my.socialMedia.logosPath}")
	private String logoPath;

	@Value("${my.dateTimeFormat}")
	private String dateTimeFormat;

	@Override
	public boolean addSocialMediaProfile(SocialMediaProfilesRequestDto dto) {
		try {
			String socialMediaName = dto.getName();
			String socialMediaUrl = dto.getUrl();
			MultipartFile socialMediaLogo = dto.getImage();
			String imagePath = logoPath + socialMediaLogo.getOriginalFilename();
			SimpleDateFormat format = new SimpleDateFormat(dateTimeFormat);

			Path uploadPath = Paths.get(logoPath);
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}

			socialMediaLogo.transferTo(Paths.get(imagePath));

			SocialMediaProfiles profile = new SocialMediaProfiles();
			profile.setName(socialMediaName);
			profile.setUrl(socialMediaUrl);
			profile.setImagePath(imagePath);
			profile.setCreatedAt(Long.valueOf(format.format(new Date())));
			profile.setLastUpdatedAt(Long.valueOf(format.format(new Date())));

			socialMediaManager.save(profile);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<SocialMediaProfiles> getAllProfiles() {
		List<SocialMediaProfiles> profiles = socialMediaManager.findAll();

		return profiles;
	}

	@Override
	public boolean updateSocialMediaProfile(SocialMediaProfilesRequestDto dto) {
		int socialMediaProfileId = dto.getId();
		Optional<SocialMediaProfiles> profile = socialMediaManager.findById(socialMediaProfileId);
		if (profile.isEmpty()) {
			return false;
		}
		try {
			SocialMediaProfiles myProfile = profile.get();
			
			Path oldImagePath = Paths.get(myProfile.getImagePath());
			Files.deleteIfExists(oldImagePath);
			
			String socialMediaName = dto.getName();
			String socialMediaUrl = dto.getUrl();
			MultipartFile socialMediaLogo = dto.getImage();
			String imagePath = logoPath + socialMediaLogo.getOriginalFilename();
			SimpleDateFormat format = new SimpleDateFormat(dateTimeFormat);

			Path uploadPath = Paths.get(logoPath);
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}

			socialMediaLogo.transferTo(Paths.get(imagePath));
			myProfile.setName(socialMediaName);
			myProfile.setUrl(socialMediaUrl);
			myProfile.setImagePath(imagePath);
			myProfile.setLastUpdatedAt(Long.valueOf(format.format(new Date())));

			socialMediaManager.save(myProfile);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProfile(int profileId) {
		Optional<SocialMediaProfiles> profile = socialMediaManager.findById(profileId);
		if(profile.isEmpty()) return false;
		socialMediaManager.deleteById(profileId);
		return true;
	}
	

}
