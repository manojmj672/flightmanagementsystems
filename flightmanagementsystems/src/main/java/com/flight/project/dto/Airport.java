package com.flight.project.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Airports")
public class Airport {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long Id;
    @Column(name="airportName")
    private String airportName;
    @Column(name="Code")
    private long Code;
    @Column(name="airportLocation")
    private String airportLocation;
	public Airport(long id, String airportName, long code, String airportLocation) {
		super();
		this.Id = id;
		this.airportName = airportName;
		this.Code = code;
		this.airportLocation = airportLocation;
	}
	public Airport() {
		super();
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		this.Id = id;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public long getCode() {
		return Code;
	}
	public void setCode(long code) {
		this.Code = code;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
    
}