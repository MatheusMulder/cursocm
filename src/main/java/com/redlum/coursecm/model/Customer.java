package com.redlum.coursecm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.redlum.coursecm.model.enums.CustomerType;

@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String legalCode;
	private Integer type;

	@OneToMany(mappedBy = "customer")
	private List<Address> adresses = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name="PHONE_NUMBERS")
	private Set<String> phoneNumbers = new HashSet<>();

	public Customer() {

	}

	public Customer(Integer id, String name, String email, String legalCode,  CustomerType type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.legalCode = legalCode;
		this.type = type.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getlegalCode() {
		return legalCode;
	}

	public void setlegalCode(String legalCode) {
		this.legalCode = legalCode;
	}

	public CustomerType getType() {
		return CustomerType.toEnum(type);
	}

	public void setType(CustomerType type) {
		this.type = type.getId();
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
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
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", legalCode=" + legalCode + ", type=" + type
				+ ", adresses=" + adresses + ", phoneNumbers=" + phoneNumbers + "]";
	}



}
