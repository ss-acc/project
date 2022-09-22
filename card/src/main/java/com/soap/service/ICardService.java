package com.soap.service;

import com.soap.entities.Card;

public interface ICardService {

	 void addCard(Card card);
	 
	 Card getCard(long cardno);
	 
}