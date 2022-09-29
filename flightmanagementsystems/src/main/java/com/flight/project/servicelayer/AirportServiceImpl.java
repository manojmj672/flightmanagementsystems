package com.flight.project.servicelayer;



import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.project.dao.AirportDaoImpl;
import com.flight.project.dto.Airport;
import com.flight.project.exception.ResourceNotFoundException;


@Service
public class AirportServiceImpl implements AirportService{
    
    private AirportDaoImpl air;



   public AirportServiceImpl(AirportDaoImpl air) {
        super();
        this.air = air;
    }

   @Override
   public Airport saveAirport(Airport airport) {
	   return air.save(airport);
 }

    @Override
    public List<Airport> getAllAirports() {
        return air.findAll();
    }

    @Override
    public Airport getAirportById(long Id) {
        // TODO Auto-generated method stub
        return air.findById(Id).orElseThrow(()->
        new ResourceNotFoundException("Airport","Id",Id));
              
    }
}