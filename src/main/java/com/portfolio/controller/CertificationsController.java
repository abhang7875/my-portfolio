package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.Certifications;
import com.portfolio.request.dto.CertificationRequestDto;
import com.portfolio.service.CertificationsService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CertificationsController {
		
	@Autowired
	private CertificationsService certificationService;
	
	@PostMapping(value="/addCertification", consumes={"multipart/form-data"})
	public HttpEntity<String> addCertification(@ModelAttribute CertificationRequestDto dto) {
		if(certificationService.addCertification(dto)) {
			return new ResponseEntity<String>("Successful..!!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed..!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getCertifications")
	public HttpEntity<List<Certifications>> getCertifications() {
		return new ResponseEntity<>(certificationService.getAllCertifications(), HttpStatus.OK);
	}
	
	@PutMapping(value="/updateCertification", consumes={"multipart/form-data"})
	public HttpEntity<String> updateCertification(@ModelAttribute CertificationRequestDto dto) {
		if(certificationService.updateCertification(dto)) {
			return new ResponseEntity<String>("Successful..!!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed..!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/deleteCertification/{certificationId}")
	public HttpEntity<String> deleteCertification(@PathVariable("certificationId") int id) {
		if(certificationService.deleteCertification(id)) {
			return new ResponseEntity<String>("Successful..!!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed..!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
