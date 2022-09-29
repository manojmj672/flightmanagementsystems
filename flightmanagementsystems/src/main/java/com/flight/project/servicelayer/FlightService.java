package com.flight.project.servicelayer;

import java.util.List;

import com.flight.project.dto.Flight;



public interface FlightService {
	Flight saveFlight(Flight flight);
	
	Flight getFlightById(long flightId);
	
	List<Flight> getAllFlight();
	
	Flight updateFlight(Flight flight, long flightId);
	
	void deleteFlight(long flightId);
}