package com.flight.project.servicelayer;
import java.util.List;

import com.flight.project.dto.Booking;


public interface BookingService {
	//save the booking slot
	public Booking saveBooking(Booking booking);
	//Getting by id:
	Booking getBookingById(long bookingid);
	//Get all:
	List<Booking> displayAllBooking();
	//Update:
	Booking updatebooking (Booking booking, long bookingid);
	//Delete:
	void deleteBooking (long bookingid);
		
	
	

}