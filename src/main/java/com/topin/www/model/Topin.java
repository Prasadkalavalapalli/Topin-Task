package com.topin.www.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="topin_task")
@Data
public class Topin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String full_name;
	private String mob_num;
	private String pan_num;
	private UUID manager_id;
	
	@OneToMany(mappedBy = "topin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TopinUpdates> updates;
	}
