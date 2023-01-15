package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.OfferDataDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.OrderData;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	String url="http://OfferService/offer?amount={amount}";
	
	String allOfferURL="http://OfferService/offer/all";

	public OrderDTO addOrderInDataBase(OrderDTO orderDTO) {
		OrderData order = orderDTO.convertToEntity();
		orderDao.save(order);
		
		ResponseEntity<OfferDataDTO> response = restTemplate.exchange(url, HttpMethod.GET, null,OfferDataDTO.class, order.getAmount());
		if(response.hasBody()) {
			orderDTO.setOfferDTO(response.getBody());
		}
		return orderDTO;
	}

	public List<OfferDataDTO> getOfferFromOfferAPI() {
		ResponseEntity<List<OfferDataDTO>> exchange = restTemplate.exchange(allOfferURL, HttpMethod.GET,null,new ParameterizedTypeReference<List<OfferDataDTO>>() {});
		return exchange.getBody();
	}
	
	

}
