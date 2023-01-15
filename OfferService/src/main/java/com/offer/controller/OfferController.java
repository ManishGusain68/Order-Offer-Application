package com.offer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.offer.entity.OfferData;
import com.offer.exception.OfferException;
import com.offer.service.OfferService;

@RestController
public class OfferController {
	
	@Autowired
	private OfferService offerService;
	
	@GetMapping("clearCache")
	public String clearCache() {
		return offerService.clearCache();
	}
	
	
	@PostMapping("/offer")
	public OfferData addOffer(@RequestBody OfferData offerData) {
		return offerService.addOfferData(offerData);
	}
	
	@GetMapping("/offer")
	public OfferData getOffer(@RequestParam int amount) {
		if(amount==0) {
			throw new OfferException("No offer available");
		}
		return offerService.getOfferData(amount);
		
	}
	
	@GetMapping("/offer/all")
	public List<OfferData> getAllOffer() {
		return offerService.getAllOffer();
	}

}
