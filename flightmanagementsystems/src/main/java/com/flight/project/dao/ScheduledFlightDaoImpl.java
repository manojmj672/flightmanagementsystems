package com.flight.project.dao;

import java.math.BigInteger;



import org.springframework.data.jpa.repository.JpaRepository;



import com.flight.project.dto.ScheduledFlight;



public interface ScheduledFlightDaoImpl extends JpaRepository <ScheduledFlight, BigInteger>   {





}