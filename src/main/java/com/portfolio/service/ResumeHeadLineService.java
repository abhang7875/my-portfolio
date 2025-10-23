package com.portfolio.service;

import org.springframework.http.HttpEntity;

import com.portfolio.entity.ResumeHeadline;
import com.portfolio.request.dto.ResumeHeadlineRequestDto;

public interface ResumeHeadLineService {
	
	public HttpEntity<ResumeHeadline> updateResumeHeadline(String resumeHeadline);
	
	public HttpEntity<ResumeHeadlineRequestDto> getHeadline();
}
