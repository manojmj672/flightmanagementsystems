package com.flight.project.servicelayer;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.project.dao.FlightDao;
import com.flight.project.dto.Flight;
import com.flight.project.exception.ResourceNotFoundException;



@Service
public class FlightServiceImpl implements FlightService{
	
	private FlightDao flightdao;

	public FlightServiceImpl(FlightDao flightdao) {
		super();
		this.flightdao = flightdao;
	}
	//Create:
	@Override
	public Flight saveFlight(Flight flight) {
		return flightdao.save(flight);
	}
	//Get by id:
	@Override
	public Flight getFlightById(long flightId) {
		return flightdao.findById(flightId).orElseThrow( ()->
		new ResourceNotFoundException("Flight","Id",flightId));
	}

	@Override
	public List<Flight> getAllFlight() {
		return flightdao.findAll();
	}

	@Override
	public Flight updateFlight(Flight flight, long flightId) {
		Flight existingflight= flightdao.findById(flightId).orElseThrow( ()->
		new ResourceNotFoundException("Flight","Id", flightId));
		existingflight.setFlightModel(flight.getFlightModel());
		existingflight.setCarrierName(flight.getCarrierName());
		existingflight.setSeatCapacity(flight.getSeatCapacity());
		flightdao.save(existingflight);
		return existingflight;
	}

	@Override
	public void deleteFlight(long flightId) {
		flightdao.findById(flightId).orElseThrow( ()->
		new ResourceNotFoundException("Flight","Id", flightId));
		flightdao.deleteById(flightId);
		
	}
	

}