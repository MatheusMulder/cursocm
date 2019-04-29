package com.redlum.coursecm.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redlum.coursecm.model.Customer;
import com.redlum.coursecm.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

	@Autowired
	private CustomerService cs;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Customer obj = cs.find(id);
		return ResponseEntity.ok().body(obj);

	}
}
