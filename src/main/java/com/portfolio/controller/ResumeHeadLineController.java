package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.entity.ResumeHeadline;
import com.portfolio.request.dto.ResumeHeadlineRequestDto;
import com.portfolio.service.ResumeHeadLineService;


@Controller
public class ResumeHeadLineController {
	
	@Autowired
	ResumeHeadLineService resumeService;
	
	@GetMapping("/headline")
	public HttpEntity<String> getHeadline() {
		return resumeService.getHeadline();
	}
	
	@PutMapping("/addHeadline")
	public HttpEntity<ResumeHeadline> updateHeadLine(@RequestBody ResumeHeadlineRequestDto requestDto) {
		String headline = requestDto.getHeadLine();
		return resumeService.updateResumeHeadline(headline);
	}

}
