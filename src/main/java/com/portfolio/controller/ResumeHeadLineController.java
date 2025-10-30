package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.ResumeHeadline;
import com.portfolio.request.dto.ResumeHeadlineRequestDto;
import com.portfolio.service.ResumeHeadLineService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/headline")
public class ResumeHeadLineController {
	
	@Autowired
	ResumeHeadLineService resumeService;	
	
	@GetMapping("/view")
	public HttpEntity<ResumeHeadlineRequestDto> getHeadline() {
		return resumeService.getHeadline();
	}
	
	@PutMapping("/update")
	public HttpEntity<ResumeHeadline> updateHeadLine(@RequestBody ResumeHeadlineRequestDto requestDto) {
		String headline = requestDto.getHeadLine();
		return resumeService.updateResumeHeadline(headline);
	}

}
