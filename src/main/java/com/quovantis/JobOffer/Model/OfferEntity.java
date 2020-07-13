package com.quovantis.JobOffer.Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name = "offer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OfferEntity implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="jobTitle",unique = true)
	private String jobTitle;
	
	@CreatedDate
	@Column(name="startDate")
	private  Date startDate;
	
	@Column(name="numberOfApplications")
	private int numberOfApplications;
	
	@OneToMany(mappedBy = "offer", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<ApplicationEntity> application;
	
}
