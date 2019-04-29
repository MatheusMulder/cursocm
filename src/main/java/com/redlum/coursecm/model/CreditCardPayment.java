package com.redlum.coursecm.model;

import javax.persistence.Entity;

import com.redlum.coursecm.model.enums.PaymentState;

@Entity
public class CreditCardPayment extends Payment {
	private static final long serialVersionUID = 1L;
	private Integer installments;

	public CreditCardPayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCardPayment(Integer id, PaymentState state, Order order, Integer installments) {
		super(id, state, order);
		this.installments = installments;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

}
