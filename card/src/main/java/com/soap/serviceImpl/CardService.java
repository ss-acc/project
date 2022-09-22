package com.soap.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soap.entities.Card;
import com.soap.repo.CardRepository;
import com.soap.service.ICardService;

@Service
public class CardService implements ICardService {

	 @Autowired
	 CardRepository cardRepository;	
	
	@Override
	public Card getCard(long cardno) {
		
		Card obj = cardRepository.findByCardno(cardno);
		return obj;
		
	}

	@Override
	public void addCard(Card card) {
		cardRepository.save(card);
	}

	
}
