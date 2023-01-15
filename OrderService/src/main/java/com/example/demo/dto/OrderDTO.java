package com.example.demo.dto;

import com.example.demo.entity.OrderData;

public class OrderDTO {

	int orderId;
	String customerName;
	int amount;
	long phoneNumber;
	OfferDataDTO offerDTO;

	

	public OfferDataDTO getOfferDTO() {
		return offerDTO;
	}

	public void setOfferDTO(OfferDataDTO offerDTO) {
		this.offerDTO = offerDTO;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public OrderData convertToEntity() {
		OrderData order=new OrderData();
		order.setOrderId(this.getOrderId());
		order.setCustomerName(this.getCustomerName());
		order.setAmount(this.getAmount());
		order.setPhoneNumber(this.getPhoneNumber());
		return order;
	}

}
