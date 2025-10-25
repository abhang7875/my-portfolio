package com.portfolio.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Experience {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String designation;
	
	@Column
	private String client;
	
	@Column(name = "from_date")
	private String from;
	
	@Column(name = "to_date")
	private String to;
	
	@OneToMany(mappedBy = "experience", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Responsibilities> responsibilities;
}
