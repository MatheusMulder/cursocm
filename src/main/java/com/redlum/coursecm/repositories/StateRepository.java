package com.redlum.coursecm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redlum.coursecm.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
