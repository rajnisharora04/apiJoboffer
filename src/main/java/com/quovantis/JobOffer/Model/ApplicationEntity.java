package com.quovantis.JobOffer.Model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import lombok.Data;

@Entity
@Data
@Table(name = "application")
public class ApplicationEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="relatedOffer")
	private String relatedOffer;
	
	@Column(name="candidateEmail",unique = true)
	private String candidateEmail;
	
	
	@Column(name="resumeText")
	private String resumeText;
	
	@Enumerated(EnumType.STRING)
	@Column(name="applicationStatus")
	private ApplicationStatus applicationStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "offerId")
    private OfferEntity offer;
}

