package com.flight.project.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.project.dto.Flight;



public interface FlightDao extends JpaRepository<Flight, Long>{

}
