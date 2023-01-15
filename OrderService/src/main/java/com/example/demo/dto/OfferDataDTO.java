package com.example.demo.dto;

public class OfferDataDTO {
	String offerName;
	int minAmount;
	int maxAmount;
	int discount;
	
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public int getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}
	public int getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "OfferData [offerName=" + offerName + ", minAmount=" + minAmount + ", maxAmount=" + maxAmount
				+ ", discount=" + discount + "]";
	}
	
	
	

}
