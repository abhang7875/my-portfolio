package com.portfolio.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.entity.Certifications;
import com.portfolio.repository.CertificationDAO;
import com.portfolio.request.dto.CertificationRequestDto;
import com.portfolio.service.CertificationsService;

@Service
public class CertificationsServiceImpl implements CertificationsService {

	@Autowired
	private CertificationDAO certificationManager;
	
	@Value("${my.certificate.logosPath}")
	private String logoPath;
	
	@Value("${my.certificate.path}")
	private String certificateImagePath;


	@Override
	public boolean addCertification(CertificationRequestDto dto) {
		try {
			String certificationName = dto.getName();
			String description = dto.getDescription();
			String issueDate = dto.getIssueDate();
			String issuedBy = dto.getIssuedBy();
			MultipartFile logoFile = dto.getLogoImage();
			MultipartFile certificateFile = dto.getCertificateImage();
			
			if(logoFile != null) {
				Path uploadPath = Paths.get(logoPath);
				if (!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}

				logoFile.transferTo(Paths.get(logoPath + logoFile.getOriginalFilename()));
			}
			
			if(certificateFile != null) {
				Path uploadPath = Paths.get(certificateImagePath);
				if (!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}
	
				certificateFile.transferTo(Paths.get(certificateImagePath + certificateFile.getOriginalFilename()));
			}
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(issueDate);

			Certifications certification = new Certifications();
			certification.setName(certificationName);
			certification.setDescription(description);
			if(logoFile != null) certification.setLogoPath(logoFile.getOriginalFilename());
			if(certificateFile != null) certification.setCertificatePath(certificateFile.getOriginalFilename());
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
			Certifications certification = certifications.get();

			Files.deleteIfExists(Paths.get(certification.getLogoPath()));			
			Files.deleteIfExists(Paths.get(certification.getCertificatePath()));
			
			String certificationName = dto.getName();
			String description = dto.getDescription();
			String issueDate = dto.getIssueDate();
			String issuedBy = dto.getIssuedBy();
			MultipartFile logoFile = dto.getLogoImage();
			MultipartFile certificateFile = dto.getCertificateImage();
			
			if(logoFile != null) {
				Path uploadPath = Paths.get(logoPath);
				if (!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}

				logoFile.transferTo(Paths.get(logoPath + logoFile.getOriginalFilename()));
			}
			
			if(certificateFile != null) {
				Path uploadPath = Paths.get(certificateImagePath);
				if (!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}
	
				certificateFile.transferTo(Paths.get(certificateImagePath + certificateFile.getOriginalFilename()));
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(issueDate);

			certification.setName(certificationName);
			certification.setDescription(description);
			if(logoFile != null) certification.setLogoPath(logoFile.getOriginalFilename());
			if(certificateFile != null) certification.setCertificatePath(certificateFile.getOriginalFilename());
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
