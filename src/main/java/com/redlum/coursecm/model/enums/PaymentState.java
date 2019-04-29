package com.redlum.coursecm.model.enums;

public enum PaymentState {

	PENDENTE(1, "P"), QUITADO(2, "Q"), CANCELADO(3, "C");

	private Integer id;
	private String description;

	private PaymentState(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public static PaymentState toEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (PaymentState ct : PaymentState.values()) {
			if (ct.getId().equals(id)) {
				return ct;
			}
		}

		throw new IllegalArgumentException("Invalid id: " + id);

	}

}
