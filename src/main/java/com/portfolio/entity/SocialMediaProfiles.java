package com.portfolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SocialMediaProfiles {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String name;
	
	@Column 
	private String url;
	
	@Column
	private String imagePath;
	
	@Column
	private long createdAt;
	
	@Column
	private long lastUpdatedAt;
	
	
	
}
