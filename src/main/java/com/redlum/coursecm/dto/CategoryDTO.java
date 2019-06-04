package com.redlum.coursecm.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.redlum.coursecm.model.Category;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Need to be filled")
	@Length(min=5, max=80, message="At least need have 5 characters and maximun of 80 characters")
	private String name;

	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(Category obj) {
		id = obj.getId();
		name = obj.getName();
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

}
