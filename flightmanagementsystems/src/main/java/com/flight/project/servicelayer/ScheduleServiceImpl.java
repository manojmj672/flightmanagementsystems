package com.flight.project.servicelayer;
import java.math.BigInteger;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.project.dao.ScheduleDaoImpl;
import com.flight.project.dto.Schedule;
import com.flight.project.exception.ResourceNotFoundException;



@Service
public class ScheduleServiceImpl implements ScheduleService{
    
    //DI
    @Autowired
    private ScheduleDaoImpl scheduleRepository;
    
    //CI
    public ScheduleServiceImpl(ScheduleDaoImpl scheduleRepository) {
        super();
        this.scheduleRepository=scheduleRepository;
    }
    
    @Override
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
    
    @Override
    public List<Schedule> getAllSchedule(){
        return scheduleRepository.findAll();
    }
    
    @Override
    public Schedule getScheduleById(BigInteger id) {
        return scheduleRepository.findById(id).orElseThrow(()->
        new ResourceNotFoundException("Schedule","Id",id));
    }
    
    @Override
    public Schedule updateSchedule(Schedule schedule,BigInteger id) {
        Schedule existingSchedule = scheduleRepository.findById(id).orElseThrow( ()->
        new ResourceNotFoundException("Schedule","id",id));
       existingSchedule.setArrivalTime(schedule.getArrivalTime());
       existingSchedule.setDepartureTime(schedule.getDepartureTime());
       existingSchedule.setDestinationAirport(schedule.getDestinationAirport());
       existingSchedule.setSourceAirport(schedule.getSourceAirport());
       scheduleRepository.save(existingSchedule);
       return existingSchedule ;
    }
    
    @Override
    public void deleteSchedule(BigInteger id) {
        scheduleRepository.findById(id).orElseThrow( ()->
        new ResourceNotFoundException("Schedule","Id",id));
        scheduleRepository.deleteById(id);
    }



}