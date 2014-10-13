package com.imaginea.androidapps;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 7848459684485345676L;
	private int customerId;
	private String customerFistName;
	private String customerLastName;
	private String customerGender;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFistName() {
		return customerFistName;
	}

	public void setCustomerFistName(String customerFistName) {
		this.customerFistName = customerFistName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
}
