package com.flight.project.servicelayer;

import java.math.BigInteger;
import java.util.List;

import com.flight.project.dto.Schedule;

public interface ScheduleService {
    
    
    Schedule saveSchedule(Schedule schedule);
    
    List<Schedule> getAllSchedule();
    
    Schedule getScheduleById(BigInteger id);
    
    Schedule updateSchedule(Schedule schedule,BigInteger id);
    
    void deleteSchedule(BigInteger id);



}