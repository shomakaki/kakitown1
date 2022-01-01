package com.example.demo.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class OrderForm {
	
	@NotBlank(message="名前を入力してください")
	private String destinationName;
	
	@Email(message="メールアドレス形式で入力してください")
	@NotBlank(message="メールを入力してください")
	private String destinationEmail;
	
	@NotBlank(message="入力してください")
	@Pattern(regexp ="^[0-9]{3}-[0-9]{4}$|$" ,message="XXX-XXXX形式で入力してください")
	private String destinationZipcode;
	
	@NotBlank(message="住所を入力してください")
	private String destinationAddress;

	@NotBlank(message="電話番号を入力してください")
	@Pattern(regexp="^[0-9]{1,4}-[0-9]{1,4}-[0-9]{1,4}$|^$", message="電話番号はXXXX-XXXX-XXXXの形式で入力してください")
	private String destinationTel;
	
	
	private String deliveryTime;
	
	private String paymentMethod;
	
	private Date orderDate;

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

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
