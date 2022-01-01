package com.example.demo.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;




public class Order {
private Integer id;
	
	private Integer userId;
	
	private Integer status;
	
	private Integer totalPrice;
	
	private Date orderDate;
	
	private String destinationName;
	
	private String destinationEmail;
	
	private String destinationZipcode;
	
	private String destinationAddress;
	
	private String destinationTel;
	
	private Timestamp deliveryTime;
	
	private Integer paymentMethod;
	
	private User user;
	
private List<Cart> cartItemList;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}

public Integer getStatus() {
	return status;
}

public void setStatus(Integer status) {
	this.status = status;
}

public Integer getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(Integer totalPrice) {
	this.totalPrice = totalPrice;
}

public Date getOrderDate() {
	return orderDate;
}

public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}

public String getDestinationName() {
	return destinationName;
}

public void setDestinationName(String destinationName) {
	this.destinationName = destinationName;
}

public String getDestinationEmail() {
	return destinationEmail;
}

public void setDestinationEmail(String destinationEmail) {
	this.destinationEmail = destinationEmail;
}

public String getDestinationZipcode() {
	return destinationZipcode;
}

public void setDestinationZipcode(String destinationZipcode) {
	this.destinationZipcode = destinationZipcode;
}

public String getDestinationAddress() {
	return destinationAddress;
}

public void setDestinationAddress(String destinationAddress) {
	this.destinationAddress = destinationAddress;
}

public String getDestinationTel() {
	return destinationTel;
}

public void setDestinationTel(String destinationTel) {
	this.destinationTel = destinationTel;
}

public Timestamp getDeliveryTime() {
	return deliveryTime;
}

public void setDeliveryTime(Timestamp deliveryTime) {
	this.deliveryTime = deliveryTime;
}

public Integer getPaymentMethod() {
	return paymentMethod;
}

public void setPaymentMethod(Integer paymentMethod) {
	this.paymentMethod = paymentMethod;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public List<Cart> getCartItemList() {
	return cartItemList;
}

public void setCartItemList(List<Cart> cartItemList) {
	this.cartItemList = cartItemList;
}
	
//	//消費税を計算するメソッド
//	
//	public int getTax() {
//		
//		int toalPriceMinusTax = 0;
//		
//		for(Cart cart : cartItemList) {
//			toalPriceMinusTax += cart.getSubTotal();
//		}
//		
//		int tax = (int)(toalPriceMinusTax * 0.1);
//		return tax;
//	}
//	
//	//合計金額を計算するメソッド
//	
//	public int getCalcTotalPrice() {
//		
//		int toalPriceMinusTax = 0;
//		
//		for(Cart cart : cartItemList) {
//			toalPriceMinusTax += cart.getSubTotal();
//		}
//		
//		totalPrice = (int)(toalPriceMinusTax * 1.1);
//		return totalPrice;
//		
//	}


}
