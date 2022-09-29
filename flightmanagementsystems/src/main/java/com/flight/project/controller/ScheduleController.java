package com.flight.project.controller;
import java.math.BigInteger;
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

import com.flight.project.dto.Schedule;
import com.flight.project.servicelayer.ScheduleService;





@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    
    //DI
    private ScheduleService scheduleService;
    
    //CI
    public ScheduleController(ScheduleService scheduleService) {
        super();
        this.scheduleService=scheduleService;
    }
    
    @PostMapping
    public ResponseEntity<Schedule> saveSchedule(@RequestBody Schedule schedule){
        return new ResponseEntity<Schedule>(scheduleService.saveSchedule(schedule),
                HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Schedule> getAllSchedule(){
        return scheduleService.getAllSchedule();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable("id") BigInteger scheduleId){
        return new ResponseEntity<Schedule>(scheduleService.getScheduleById(scheduleId),
                HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable("id") BigInteger id,
            @RequestBody Schedule schedule){
        return new ResponseEntity<Schedule>(scheduleService.updateSchedule(schedule,id),
                HttpStatus.OK);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable("id")BigInteger id){
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<String>("Schedule data deleted succesfully",HttpStatus.OK);
    }



}