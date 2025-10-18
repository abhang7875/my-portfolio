package com.portfolio.service;

import org.springframework.http.HttpEntity;

import com.portfolio.entity.ResumeHeadline;

public interface ResumeHeadLineService {
	
	public HttpEntity<ResumeHeadline> updateResumeHeadline(String resumeHeadline);
	
	public HttpEntity<String> getHeadline();
}
