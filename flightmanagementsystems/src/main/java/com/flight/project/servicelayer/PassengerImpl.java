package com.flight.project.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.project.dao.PassengerDao;
import com.flight.project.dto.Passenger;
import com.flight.project.exception.ResourceNotFoundException;




@Service
public class PassengerImpl implements PassengerService{
 @Autowired
 private PassengerDao passengerRepository;

public PassengerImpl( PassengerDao passengerRepository) {
	super();
	this.passengerRepository = passengerRepository;
}

@Override
public Passenger savePassenger(Passenger passenger) {
	return passengerRepository.save(passenger);
}

@Override
public List<Passenger> getAllPassengers() {
	return passengerRepository.findAll();
}

@Override
public Passenger getPassengerById(long pnrNumber) {
	return passengerRepository.findById(pnrNumber).orElseThrow(()->
	new ResourceNotFoundException("Passenger","pnrNumber",pnrNumber));
}

@Override
public Passenger updatePassenger(Passenger passenger, long pnrNumber) {
	Passenger existingPassenger=passengerRepository.findById(pnrNumber).orElseThrow(()->
	new ResourceNotFoundException("Passenger","pnrNumber",pnrNumber));

	//existing
	//existingPassenger.setPnrNumber(passenger.getPnrNumber());
	existingPassenger.setPassengerName(passenger.getPassengerName());
	existingPassenger.setPassengerAge(passenger.getPassengerAge());
	existingPassenger.setPassengerUIN(passenger.getPassengerUIN());
	existingPassenger.setNoofluggages(passenger.getNoofluggages());
	passengerRepository.save(existingPassenger);

	return existingPassenger ;
}

@Override
public void deletePassenger(long pnrNumber) {
	passengerRepository.findById(pnrNumber).orElseThrow(()->
	new ResourceNotFoundException("Passenger","pnrNumber",pnrNumber));
	passengerRepository.deleteById(pnrNumber);

}



}