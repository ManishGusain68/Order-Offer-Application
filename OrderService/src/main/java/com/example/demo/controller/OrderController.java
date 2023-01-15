package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OfferDataDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.OrderData;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order/addOrder")
	public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) {
		return orderService.addOrderInDataBase(orderDTO);
	}
	
	@GetMapping("/order/offers")
	public List<OfferDataDTO> getOfferFromOfferAPI() {
		return orderService.getOfferFromOfferAPI();
	}

}
