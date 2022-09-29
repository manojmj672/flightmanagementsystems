package com.flight.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.project.dto.Airport;

public interface AirportDaoImpl extends JpaRepository<Airport,Long>{
	

}
