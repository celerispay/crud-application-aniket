package com.example.payApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payApp.models.Upi;
import com.example.payApp.repositoyService.UpiRepoService;

@Service
public class UpiServiceImpl implements UpiService {
	
	@Autowired
	private UpiRepoService upiRepoService;

	@Override
	public Upi addUpi(Long id, Upi upi) {
		return upiRepoService.save(id, upi);
	}

}
