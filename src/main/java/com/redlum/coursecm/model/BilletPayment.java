package com.redlum.coursecm.model;

import java.util.Date;

import javax.persistence.Entity;

import com.redlum.coursecm.model.enums.PaymentState;

@Entity
public class BilletPayment extends Payment {
	private static final long serialVersionUID = 1L;

	private Date paymentDate;
	private Date dueDate;

	public BilletPayment() {

	}

	public BilletPayment(Integer id, PaymentState state, Order order, Date paymentDate, Date dueDate) {
		super(id, state, order);
		this.paymentDate = paymentDate;
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
