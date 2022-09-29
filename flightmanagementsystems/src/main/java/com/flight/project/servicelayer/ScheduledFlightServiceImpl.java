package com.flight.project.servicelayer;

import java.math.BigInteger;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.flight.project.dao.ScheduledFlightDaoImpl;
import com.flight.project.dto.ScheduledFlight;
import com.flight.project.exception.ResourceNotFoundException;



@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {
    
    //Dependence injection
    @Autowired
    private ScheduledFlightDaoImpl ScheduledFlightrepository;





  //Constructor injection -----> stores the value
    public ScheduledFlightServiceImpl(ScheduledFlightDaoImpl scheduledFlightrepository) {
        super();
        ScheduledFlightrepository = scheduledFlightrepository;
    }





  @Override
    public ScheduledFlight saveScheduledFlight(ScheduledFlight scheduledflight) {
        return ScheduledFlightrepository.save(scheduledflight);
    }
    
    @Override
    public List<ScheduledFlight> getAllScheduledFlight() {
        return ScheduledFlightrepository.findAll();
    }
    
    @Override
    public ScheduledFlight getScheduledFlightById(BigInteger id)
    {
        return ScheduledFlightrepository.findById(id).orElseThrow( () ->
        new ResourceNotFoundException("scheduledflight", "Id", id));
    }
    
    @Override
    public ScheduledFlight updateScheduledFlight(ScheduledFlight scheduledflight, BigInteger id)
    {
        ScheduledFlight existingScheduledFlight = ScheduledFlightrepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("scheduledflight", "Id", id));
        
        existingScheduledFlight.setFlight(scheduledflight.getFlight());
        existingScheduledFlight.setAvailableSeats(scheduledflight.getAvailableSeats());
        existingScheduledFlight.setSchedule(scheduledflight.getSchedule());
        //save
        ScheduledFlightrepository.save(existingScheduledFlight);
        return existingScheduledFlight;
        
    }
    
    @Override
    public void deleteScheduledFlight(BigInteger id)
    {
        ScheduledFlightrepository.findById(id).orElseThrow( () ->
        new ResourceNotFoundException("scheduledflight", "Id", id));
        ScheduledFlightrepository.deleteById(id);
    }
    





}

