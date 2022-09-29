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

import com.flight.project.dto.Booking;
import com.flight.project.servicelayer.BookingService;



@RestController
@RequestMapping("/booking")
public class BookingController {
	private BookingService bookingService;

	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	//Posting:
	@PostMapping
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking){
		return new ResponseEntity<Booking> (bookingService.saveBooking(booking), HttpStatus.CREATED);
	}
	
	//Getting by Id:
	@GetMapping("{bookingid}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("bookingid") long bId, @RequestBody Booking booking){
		return new ResponseEntity<Booking>
		(bookingService.getBookingById(bId), HttpStatus.OK);
	}
	
	//Get all:
	@GetMapping
	public List<Booking> displayAllBooking(){
		return bookingService.displayAllBooking();	}
	
	//Update: 
	@PutMapping("{bookingId}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("bookingId") long bId, @RequestBody Booking booking){
		return new ResponseEntity <Booking>
		(bookingService.updatebooking(booking, bId), HttpStatus.OK);
	}
	
	//Delete: 
	@DeleteMapping("{bookingId}")
	public ResponseEntity<String> deleteBooking(@PathVariable("bookingId") long bId){
		bookingService.deleteBooking(bId);
		return new ResponseEntity<String>
		("Booking data has been deleted.", HttpStatus.OK);
	}
}