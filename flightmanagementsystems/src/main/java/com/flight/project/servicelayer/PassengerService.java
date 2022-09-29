package com.flight.project.servicelayer;

import java.util.List;

import com.flight.project.dto.Passenger;



public interface PassengerService {
	//save
    Passenger savePassenger(Passenger passenger);
    //findAll
    List<Passenger> getAllPassengers();
    //find
    Passenger getPassengerById(long pnrNumber);
    //update
    Passenger updatePassenger(Passenger passenger,long pnrNumber);
    //delete
    void deletePassenger(long pnrNumber);

}