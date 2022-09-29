package com.flight.project.servicelayer;

import java.math.BigInteger;
import java.util.List;



import com.flight.project.dto.ScheduledFlight;



public interface ScheduledFlightService  {
    
    ScheduledFlight saveScheduledFlight(ScheduledFlight scheduledflight);
//    FindALL
    List<ScheduledFlight> getAllScheduledFlight();
//    FindByID
    ScheduledFlight getScheduledFlightById(BigInteger id);
    //Update
    ScheduledFlight updateScheduledFlight(ScheduledFlight scheduledflight, BigInteger id);
    //Delete
    void deleteScheduledFlight(BigInteger id);

}
