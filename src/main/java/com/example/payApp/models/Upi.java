package com.example.payApp.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "upidetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Upi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "upiid")
	private String upiId;
	
	

	@OneToOne
    @MapsId
    @JoinColumn(name = "customerId")
	private Customer customer;
	
	public Upi(String upiId, Customer customer) {
		super();
		this.upiId = upiId;
		this.customer = customer;
	}
}
