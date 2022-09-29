package com.flight.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.project.dto.Booking;



public interface BookingDao extends JpaRepository<Booking, Long> {

}