package com.portfolio.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Certifications {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String logoPath;
	
	@Column
	private String certificatePath;
	
	@Column
	private String description;
	
	@Column
	private Date issueDate;
	
	@Column
	private String issuedBy;
	
	
}
