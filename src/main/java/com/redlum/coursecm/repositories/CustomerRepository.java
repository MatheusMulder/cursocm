package com.redlum.coursecm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redlum.coursecm.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
