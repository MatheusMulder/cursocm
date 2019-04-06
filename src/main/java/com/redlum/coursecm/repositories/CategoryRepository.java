package com.redlum.coursecm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redlum.coursecm.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
