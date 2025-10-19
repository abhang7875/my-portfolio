package com.portfolio.service;

import java.util.List;

import com.portfolio.entity.Certifications;
import com.portfolio.request.dto.CertificationRequestDto;

public interface CertificationsService {
	
	public boolean addCertification(CertificationRequestDto dto);
	
	public List<Certifications> getAllCertifications();
	
	public boolean updateCertification(CertificationRequestDto dto);
	
	public boolean deleteCertification(int certificationId);

}
