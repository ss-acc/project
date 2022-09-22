package com.soap.card;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.entities.Card;
import com.soap.interfaces.AddCardRequest;
import com.soap.interfaces.AddCardResponse;
import com.soap.interfaces.CardInfo;
import com.soap.interfaces.GetCardRequest;
import com.soap.interfaces.GetCardResponse;
import com.soap.interfaces.ServiceStatus;
import com.soap.serviceImpl.CardService;

@Endpoint
public class CardEndpoint {

	private static final String NAMESPACE_URI = "http://interfaces.soap.com";

	@Autowired
	private CardService cardService;


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCardRequest")
	@ResponsePayload
	public AddCardResponse addCard(@RequestPayload AddCardRequest request) {
		AddCardResponse response = new AddCardResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		Card card = new Card();
		BeanUtils.copyProperties(request.getCardInfo(), card);
		cardService.addCard(card);
		serviceStatus.setStatus("SUCCESS");
 	    serviceStatus.setMessage("A new card is added to the system");
		response.setServiceStatus(serviceStatus);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCardRequest")
	@ResponsePayload
	public GetCardResponse getCard(@RequestPayload GetCardRequest request) {
		GetCardResponse response = new GetCardResponse();
		CardInfo cardInfo = new CardInfo();
		BeanUtils.copyProperties(cardService.getCard(request.getCardno()), cardInfo);
		response.setCardInfo(cardInfo);
		return response;
	}



}

