package com.redlum.coursecm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redlum.coursecm.model.Customer;
import com.redlum.coursecm.repositories.CustomerRepository;
import com.redlum.service.exceptions.ObjectNotFoundException;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	public Customer find(Integer id)   {
		Optional<Customer> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException( "Object not found with id: " + 
														id + ", tipo: " + Customer.class.getName()));

	}
}
