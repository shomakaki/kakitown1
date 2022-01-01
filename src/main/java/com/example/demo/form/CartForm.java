package com.example.demo.form;

public class CartForm {
	
	private String id;
	
	private String itemId;
	
	private String orderId;
	
	private String quantity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartForm [id=" + id + ", itemId=" + itemId + ", orderId=" + orderId + ", quantity=" + quantity + "]";
	}

	
}
