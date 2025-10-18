package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.portfolio.request.dto.SocialMediaProfilesDto;
import com.portfolio.service.SocialMediaProfilesService;

@Controller
public class SocialMediaProfilesController {
	
	@Autowired
	private SocialMediaProfilesService socialMediaService;
	
	@PostMapping(value="/addProfile", consumes={"multipart/form-data"})
	public HttpEntity<String> addProfile(@ModelAttribute SocialMediaProfilesDto dto) {
		if(socialMediaService.addSocialMediaProfile(dto)) {
			return new ResponseEntity<String>("Successful..!!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed..!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
