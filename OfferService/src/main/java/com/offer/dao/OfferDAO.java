package com.offer.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.offer.entity.OfferData;

public interface OfferDAO extends CrudRepository<OfferData,Integer>{
	
	@Cacheable(value = "offerCache", key="#amount")
	OfferData findByMinAmountLessThanEqualAndMaxAmountGreaterThanEqual(int amount,int amount1);

}
