package com.portfolio.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.entity.Certifications;
import com.portfolio.repository.CertificationDAO;
import com.portfolio.request.dto.CertificationRequestDto;
import com.portfolio.service.CertificationsService;

@Service
public class CertificationsServiceImpl implements CertificationsService {

	@Autowired
	private CertificationDAO certificationManager;


	@Override
	public boolean addCertification(CertificationRequestDto dto) {
		try {
			String certificationName = dto.getName();
			String description = dto.getDescription();
			String issueDate = dto.getIsssueDate();
			String issuedBy = dto.getIssuedBy();
			
			SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY");
			Date date = format.parse(issueDate);

			Certifications certification = new Certifications();
			certification.setName(certificationName);
			certification.setDescription(description);
			certification.setIssuedBy(issuedBy);
			certification.setIssueDate(date);
			
			certificationManager.save(certification);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Certifications> getAllCertifications() {
		List<Certifications> certifications = certificationManager.findAll();

		return certifications;
	}

	@Override
	public boolean updateCertification(CertificationRequestDto dto) {
		int certificationId = dto.getId();
		Optional<Certifications> certifications = certificationManager.findById(certificationId);
		if (certifications.isEmpty()) {
			return false;
		}
		try {
			String certificationName = dto.getName();
			String description = dto.getDescription();
			String issueDate = dto.getIsssueDate();
			String issuedBy = dto.getIssuedBy();
			
			SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY");
			Date date = format.parse(issueDate);

			Certifications certification = certifications.get();
			certification.setName(certificationName);
			certification.setDescription(description);
			certification.setIssuedBy(issuedBy);
			certification.setIssueDate(date);
			
			certificationManager.save(certification);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCertification(int certificationId) {
		Optional<Certifications> certification = certificationManager.findById(certificationId);
		if(certification.isEmpty()) return false;
		certificationManager.deleteById(certificationId);
		return true;
	}
	

}
