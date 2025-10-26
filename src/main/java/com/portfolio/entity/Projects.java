package com.portfolio.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Projects {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String name;
	
	@Column(name = "from_date")
	private String from;
	
	@Column(name = "to_date")
	private String to;
	
	@Column
	private int organisationId;
	
	@Column
	private List<String> description;
}
