package com.offer.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.stereotype.Service;

import com.offer.dao.OfferDAO;
import com.offer.entity.OfferData;

@Service
public class OfferService {

	@Autowired
	private OfferDAO offerDao;

	public OfferData addOfferData(OfferData offerData) {
		return offerDao.save(offerData);
	}

	public OfferData getOfferData(int amount) {
		return offerDao.findByMinAmountLessThanEqualAndMaxAmountGreaterThanEqual(amount, amount);
//		Iterable<OfferData> allOffer = offerDao.findAll();
//		Iterator<OfferData> iterator = allOffer.iterator();
//		while (iterator.hasNext()) {
//			OfferData offerData = iterator.next();
//			if (amount<=offerData.getMaxAmount()) {
//				if (amount>=offerData.getMinAmount()  ) {
//					return offerData;
//				}
//			}
//		}
//		return null;
	}

	public List<OfferData> getAllOffer() {
		List<OfferData> offers = new ArrayList<>();
		offerDao.findAll().forEach(offer -> offers.add(offer));
		return offers;
	}

	@CacheEvict(cacheNames = "offerCache",allEntries = true )
	public String clearCache() {
		return "Cache Cleared";
	}

}
