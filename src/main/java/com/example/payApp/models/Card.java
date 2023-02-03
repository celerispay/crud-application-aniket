package com.example.payApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carddetails")
@Data
@NoArgsConstructor
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "number")
	 private String number;
	@Column(name = "expmonth")
	@NotNull
	 private String expMonth;
	@Column(name = "expyear")
	@NotNull
	 private String expYear;
	@Column(name = "cvv")
	@NotNull
	 private String cvv;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Card( @NotNull String number, @NotNull String expMonth, @NotNull String expYear,
			@NotNull String cvv, Customer customer) {
		
		this.number = number;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.cvv = cvv;
		this.customer = customer;
	}
	

}
