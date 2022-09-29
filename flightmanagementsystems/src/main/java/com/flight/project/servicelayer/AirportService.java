package com.flight.project.servicelayer;

import java.util.List;

import com.flight.project.dto.Airport;

public interface AirportService {
    
    
    Airport saveAirport(Airport airport);
   List<Airport> getAllAirports();
    Airport getAirportById(long Id);
    
}