package com.example.payApp.services;

import org.springframework.security.access.event.PublicInvocationEvent;

import com.example.payApp.models.Upi;

public interface UpiService {
		public Upi addUpi(Long id, Upi upi);
}
