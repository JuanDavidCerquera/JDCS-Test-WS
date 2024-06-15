package com.example.amonic.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "routes")
public class Routes  extends ABaseEntity{

	   @ManyToOne(fetch = FetchType.EAGER, optional = false )
	    @JoinColumn(name = "departure_airports_id", nullable = false)
	    private Airports departureAirportsId;
	   
	   @ManyToOne(fetch = FetchType.EAGER, optional = false )
	    @JoinColumn(name = "arrival_airports_id", nullable = false)
	    private Airports arrivalAirportsId;
	   
	   @Column(name = "distance", nullable = false)
	    private Double distance;
	   
	   @Column(name = "flight_time", nullable = false)
	    private Double flightTime;

	public Airports getDepartureAirportsId() {
		return departureAirportsId;
	}

	public void setDepartureAirportsId(Airports departureAirportsId) {
		this.departureAirportsId = departureAirportsId;
	}

	public Airports getArrivalAirportsId() {
		return arrivalAirportsId;
	}

	public void setArrivalAirportsId(Airports arrivalAirportsId) {
		this.arrivalAirportsId = arrivalAirportsId;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Double flightTime) {
		this.flightTime = flightTime;
	}

	
}
