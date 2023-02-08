package com.example.payApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payApp.models.Card;
import com.example.payApp.repositoy.service.CardRepoService;

@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardRepoService cardRepoService;

	@Override
	public Card addCardDeatils(Long id, Card card) {

		return cardRepoService.save(id, card);
	}

}
