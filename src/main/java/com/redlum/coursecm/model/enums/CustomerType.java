package com.redlum.coursecm.model.enums;

public enum CustomerType {

	PESSOAFISICA(1, "PF"), PESSOAJURIDICA(2, "PJ");

	private Integer id;
	private String description;

	private CustomerType(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public static CustomerType toEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (CustomerType ct : CustomerType.values()) {
			if (ct.getId().equals(id)) {
				return ct;
			}
		}

		throw new IllegalArgumentException("Invalid id: " + id);

	}

}
