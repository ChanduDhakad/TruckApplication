package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Truck {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer trackId;
	 private String vehicleNo;
	 private String color;
	 private Integer noOfWheels;
	 private String company;
	
	 
	 @OneToOne
     private User driver;

	 @ManyToOne
	 private User manager;
	 
	 
}
