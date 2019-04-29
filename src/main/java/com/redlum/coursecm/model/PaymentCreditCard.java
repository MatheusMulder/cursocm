package com.redlum.coursecm.model;

import com.redlum.coursecm.model.enums.PaymentState;

public class PaymentCreditCard extends Payment {
	private static final long serialVersionUID = 1L;
	private Integer installments;

	public PaymentCreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentCreditCard(Integer id, PaymentState state, Order order, Integer installments) {
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
