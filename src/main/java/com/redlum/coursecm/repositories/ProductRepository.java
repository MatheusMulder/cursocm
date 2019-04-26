package com.redlum.coursecm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redlum.coursecm.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
