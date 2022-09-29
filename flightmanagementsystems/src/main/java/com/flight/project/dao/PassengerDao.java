package com.flight.project.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.project.dto.Passenger;



@Repository
public interface PassengerDao extends JpaRepository<Passenger, Long>{

}