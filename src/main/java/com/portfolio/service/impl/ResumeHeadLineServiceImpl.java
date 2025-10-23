package com.portfolio.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.entity.ResumeHeadline;
import com.portfolio.repository.ResumeHeadlineDAO;
import com.portfolio.request.dto.ResumeHeadlineRequestDto;
import com.portfolio.service.ResumeHeadLineService;

@Service
public class ResumeHeadLineServiceImpl implements ResumeHeadLineService{
	
	@Autowired
	private ResumeHeadlineDAO resumeManager;
	
	@Value("${my.dateTimeFormat}")
	private String dateTimeFormat;

	@Override
	public ResponseEntity<ResumeHeadline> updateResumeHeadline(String resumeHeadline) {
		SimpleDateFormat format = new SimpleDateFormat(dateTimeFormat);
		
		Optional<ResumeHeadline> records = resumeManager.findById(1);
		ResumeHeadline newHeadline = records.isEmpty()? new ResumeHeadline() : records.get();
		
		newHeadline.setHeadline(resumeHeadline);
		newHeadline.setLastUpdatedAt(Long.valueOf(format.format(new Date())));
		
		resumeManager.save(newHeadline);
		
		return new ResponseEntity<>(newHeadline, HttpStatus.OK);
		
	}
	
	@Override
	public ResponseEntity<ResumeHeadlineRequestDto> getHeadline() {
		List<ResumeHeadline> records = resumeManager.findAll();
		if(records.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		ResumeHeadlineRequestDto dto = new ResumeHeadlineRequestDto();
		dto.setHeadLine(records.get(0).getHeadline());
		return new ResponseEntity<ResumeHeadlineRequestDto>(dto, HttpStatus.OK);
	}

}
