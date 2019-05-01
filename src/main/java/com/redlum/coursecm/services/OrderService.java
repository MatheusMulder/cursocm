package com.redlum.coursecm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redlum.coursecm.model.Order;
import com.redlum.coursecm.repositories.OrderRepository;
import com.redlum.service.exceptions.ObjectNotFoundException;


@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	public Order find(Integer id)   {
		Optional<Order> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException( "Object not found with id: " + 
														id + ", tipo: " + Order.class.getName()));

	}
}
