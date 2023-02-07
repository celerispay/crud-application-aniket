package com.example.payApp.config;

import org.springframework.batch.item.ItemProcessor;

import com.example.payApp.models.Bank;


public class BankProcessor implements ItemProcessor<Bank, Bank>{
	
	@Override
	public Bank process(Bank item) throws Exception {
		
		return item;
	}

}
