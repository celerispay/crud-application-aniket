package com.example.payApp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@Max(150)
	@NotNull(message = "Name should not empty")
	private String customerName;
	@NotNull(message = "phone number cannot be null")
	@Max(10)
	private String customerPhoneNumber;
	@Email(message = "Please enter correct email")
	@NotNull
	private String customerEmail;
	private Integer customerCurrentBalance;
	@NotNull
	private String customerPaymentMethod;
	
	public Customer(@Max(150) @NotNull(message = "Name should not empty") String customerName,
			@NotNull @Max(10) String customerPhoneNumber, @Email @NotNull String customerEmail,
			Integer customerCurrentBalance, @NotNull String customerPaymentMethod) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerEmail = customerEmail;
		this.customerCurrentBalance = customerCurrentBalance;
		this.customerPaymentMethod = customerPaymentMethod;
	}

	
	
}
