package com.flight.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.project.dto.Flight;
import com.flight.project.servicelayer.FlightService;



@RestController
@RequestMapping("/flight")
public class FlightController {
	
	private FlightService flightService;

	public FlightController(FlightService flightService) {
		super();
		this.flightService = flightService;
	}
	
	@PostMapping()
	public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight){
		return new ResponseEntity<Flight> (flightService.saveFlight(flight), HttpStatus.CREATED);
	}
	@GetMapping
	public List<Flight> getAllFlight(){
		return flightService.getAllFlight();
	}
	@GetMapping("{flightId}")
	public ResponseEntity<Flight> getFlightById(@PathVariable("flightId") long fId){
		return new ResponseEntity<Flight> (flightService.getFlightById(fId), HttpStatus.OK);
	}
	@PutMapping("{flightId}")
	public ResponseEntity<Flight> updateFlight(@PathVariable("flightId") long fId,@RequestBody Flight flight){
		return new ResponseEntity<Flight> (flightService.updateFlight(flight, fId),HttpStatus.OK);	
	}
	@DeleteMapping("{flightId}")
	public ResponseEntity<String> deleteFlight(@PathVariable("flightId") long fId){
		flightService.deleteFlight(fId);
		return new ResponseEntity<String>("Flight has been deleted",HttpStatus.OK);
	}
	

}