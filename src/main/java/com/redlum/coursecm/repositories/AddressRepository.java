package com.redlum.coursecm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redlum.coursecm.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
