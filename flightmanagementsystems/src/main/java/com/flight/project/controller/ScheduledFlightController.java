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



import com.flight.project.dto.ScheduledFlight;
import com.flight.project.servicelayer.ScheduledFlightService;



@RestController
@RequestMapping("/scheduledflight")
public class ScheduledFlightController {





  //DI
    private ScheduledFlightService scheduledflightService;
    
    //Construction injection
    public ScheduledFlightController(ScheduledFlightService scheduledflightService) {
        super();
        this.scheduledflightService = scheduledflightService;
    }
    
    //Build create DETAILS REST API
    @PostMapping()
    public ResponseEntity<ScheduledFlight> saveScheduledFlight(@RequestBody ScheduledFlight scheduledflight) {
        return new ResponseEntity<ScheduledFlight>
        (scheduledflightService.saveScheduledFlight(scheduledflight), HttpStatus.CREATED);
    }
    
    //BUILD GET ALL DETAILS REST API
    @GetMapping
    public List<ScheduledFlight> getAllScheduledFlight()
    {
        return scheduledflightService.getAllScheduledFlight();
    }
    
    //Build get details by id REST API
    @GetMapping("{id}")
    public ResponseEntity<ScheduledFlight> getScheduledFlightById(@PathVariable("id") BigInteger scheduledflightId)
    {
//        return new ResponseEntity<ScheduledFlight>(scheduledflightService.getScheduledFlightById(scheduledflightId),HttpStatus.OK);
    	return new ResponseEntity<ScheduledFlight>(scheduledflightService.getScheduledFlightById(scheduledflightId),HttpStatus.OK);
    }
    
    //Build update details REST API
    @PutMapping("{id}")
    public ResponseEntity<ScheduledFlight> updateScheduledFlight(@PathVariable("id") BigInteger id,
            @RequestBody ScheduledFlight scheduledflight)
    {
        return new ResponseEntity<ScheduledFlight>(scheduledflightService.updateScheduledFlight(scheduledflight, id), HttpStatus.OK);
    }
    
    //Build delete order REST API
    @DeleteMapping("{id}")
    public ResponseEntity<ScheduledFlight> deleteScheduledFlight(@PathVariable("id")BigInteger id)
    {
        //delete
        scheduledflightService.deleteScheduledFlight(id);
        return new ResponseEntity<ScheduledFlight>(HttpStatus.OK);
    }
    
}
