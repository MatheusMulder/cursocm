package com.redlum.coursecm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="PURCHASE_ORDER")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date orderTime;

	@OneToOne(cascade=CascadeType.ALL, mappedBy="purchaseOrder")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name="delivery_address_id")
	private Address orderAddress;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> orderItens = new HashSet<>();

	public Order() {

	}

	public Order(Integer id, Date orderTime, Customer customer, Address orderAddress) {
		this.id = id;
		this.orderTime = orderTime;
		this.customer = customer;
		this.orderAddress = orderAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(Address orderAddress) {
		this.orderAddress = orderAddress;
	}

	public Set<OrderItem> getOrderItens() {
		return orderItens;
	}

	public void setOrderItens(Set<OrderItem> orderItens) {
		this.orderItens = orderItens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTime=" + orderTime + ", payment=" + payment + ", customer=" + customer
				+ ", orderAddress=" + orderAddress + "]";
	}

}
