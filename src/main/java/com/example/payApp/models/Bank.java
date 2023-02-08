package com.example.payApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank_info")
public class Bank {
	@Id
	@Column(name = "bank_id")
	private Integer id;
	
	@Column(name = "bank")
	private String bank;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "totalassetsusb")
	private String totalAssetsusb;
	
	@Column(name = "balancesheet")
	private String balanceSheet;

}
