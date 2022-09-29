package com.flight.project.dto;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="schedule_Id")
public class Schedule {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private BigInteger scheduleId;    
    @OneToOne(fetch = FetchType.EAGER)
    private Airport sourceAirport;    
    @OneToOne(fetch = FetchType.EAGER)
    private Airport destinationAirport;
    @Column(name="arrivaldate")
    private String arrivalTime;
    @Column(name="departuredate")
    private String departureTime;
  //parameterized constructor
    public Schedule(BigInteger scheduleId, Airport sourceAirport, Airport destinationAirport, String arrivalTime,
            String departureTime) {
        super();
        this.scheduleId = scheduleId;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }
    //default constructor
    public Schedule() {
        super();
        // TODO Auto-generated constructor stub
    }
  //getter and setter
    public BigInteger getScheduleId() {
        return scheduleId;
    }
  public void setScheduleId(BigInteger scheduleId) {
        this.scheduleId = scheduleId;
    }
  public Airport getSourceAirport() {
        return sourceAirport;
    }
  public void setSourceAirport(Airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }
  public Airport getDestinationAirport() {
        return destinationAirport;
    }
  public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }
  public String getArrivalTime() {
        return arrivalTime;
    }
  public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
  public String getDepartureTime() {
        return departureTime;
    }
  public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}


