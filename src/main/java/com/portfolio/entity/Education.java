package com.portfolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="my_education_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {
	
	@Column
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String organisation;
	
	@Column
	private String degree;
	
	@Column(name="from_date")
	private String from;
	
	@Column(name="to_date")
	private String to;
	
	@Column
	private long lastUpdatedAt;

}
