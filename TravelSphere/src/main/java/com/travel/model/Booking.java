package com.travel.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data

public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String bookingType="online";
	
	@Min(1)
	private Integer member;
	
	
	private LocalDateTime bookingDate=LocalDateTime.now();
	
	@NotNull
	private Integer customerId;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Package packageDetails;
    
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	
	
}
