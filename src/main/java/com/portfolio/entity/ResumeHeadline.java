package com.portfolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "HEADLINE")
@Data
public class ResumeHeadline {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(columnDefinition = "TEXT")
	private String headline;
	
	@Column
	private long lastUpdatedAt;
	
}
