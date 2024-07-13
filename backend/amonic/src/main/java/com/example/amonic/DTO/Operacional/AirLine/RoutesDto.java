package com.example.amonic.DTO.Operacional.AirLine;

public class RoutesDto {

	private Long departureAirportsId;

	private Long arrivalAirportsId;

	private Double distance;

	private Double flightTime;

	public Long getDepartureAirportsId() {
		return departureAirportsId;
	}

	public void setDepartureAirportsId(Long departureAirportsId) {
		this.departureAirportsId = departureAirportsId;
	}

	public Long getArrivalAirportsId() {
		return arrivalAirportsId;
	}

	public void setArrivalAirportsId(Long arrivalAirportsId) {
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
