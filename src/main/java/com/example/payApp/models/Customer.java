package com.example.payApp.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@Column(name = "cutomerId")
	private Long customerId;
	@Max(150)
	@NotNull(message = "Name should not empty")
	@Column(name = "customername")
	private String customerName;
	@NotNull(message = "phone number cannot be null")
	@Max(10)
	@Column(name = "customernumber")
	private String customerPhoneNumber;
	@Email(message = "Please enter correct email")
	@NotNull
	@Column(name = "customeremail")
	private String customerEmail;
	@Column(name = "balance")
	private Integer customerCurrentBalance;
	@NotNull
	@Column(name = "paymentmethod")
	private String customerPaymentMethod;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Card> cardset;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Upi upi;

	public Customer(Long customerId, @Max(150) @NotNull(message = "Name should not empty") String customerName,
			@NotNull(message = "phone number cannot be null") @Max(10) String customerPhoneNumber,
			@Email(message = "Please enter correct email") @NotNull String customerEmail,
			Integer customerCurrentBalance, @NotNull String customerPaymentMethod) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerEmail = customerEmail;
		this.customerCurrentBalance = customerCurrentBalance;
		this.customerPaymentMethod = customerPaymentMethod;
	}


	public Customer(@Max(150) @NotNull(message = "Name should not empty") String customerName,
			@NotNull(message = "phone number cannot be null") @Max(10) String customerPhoneNumber,
			@Email(message = "Please enter correct email") @NotNull String customerEmail,
			Integer customerCurrentBalance, @NotNull String customerPaymentMethod) {
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerEmail = customerEmail;
		this.customerCurrentBalance = customerCurrentBalance;
		this.customerPaymentMethod = customerPaymentMethod;
	}

}
