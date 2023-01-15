package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.dto.OrderDTO;



@Entity
public class OrderData {
	@Id
	int orderId;
	String customerName;
	int amount;
	long phoneNumber;

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

	public OrderDTO convertToDTO() {
		OrderDTO order=new OrderDTO();
		order.setOrderId(this.getOrderId());
		order.setCustomerName(this.getCustomerName());
		order.setAmount(this.getAmount());
		order.setPhoneNumber(this.getPhoneNumber());
		return order;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", amount=" + amount + ", phoneNumber="
				+ phoneNumber + "]";
	}

}
