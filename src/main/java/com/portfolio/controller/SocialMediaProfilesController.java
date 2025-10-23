package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.portfolio.entity.SocialMediaProfiles;
import com.portfolio.request.dto.SocialMediaProfilesRequestDto;
import com.portfolio.service.SocialMediaProfilesService;


@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class SocialMediaProfilesController {
		
	@Autowired
	private SocialMediaProfilesService socialMediaService;
	
	@PostMapping(value="/addProfile", consumes={"multipart/form-data"})
	public HttpEntity<String> addProfile(@ModelAttribute SocialMediaProfilesRequestDto dto) {
		if(socialMediaService.addSocialMediaProfile(dto)) {
			return new ResponseEntity<String>("Successful..!!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed..!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getAllProfiles")
	public HttpEntity<List<SocialMediaProfiles>> getMySocialMediaProfiles() {
		return new ResponseEntity<>(socialMediaService.getAllProfiles(), HttpStatus.OK);
	}
	
	@PutMapping(value="/updateProfile", consumes={"multipart/form-data"})
	public HttpEntity<String> updateProfile(@ModelAttribute SocialMediaProfilesRequestDto dto) {
		if(socialMediaService.updateSocialMediaProfile(dto)) {
			return new ResponseEntity<String>("Successful..!!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed..!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/deleteProfile/{profileId}")
	public HttpEntity<String> deleteProfile(@PathVariable("profileId") int id) {
		if(socialMediaService.deleteProfile(id)) {
			return new ResponseEntity<String>("Successful..!!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed..!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
