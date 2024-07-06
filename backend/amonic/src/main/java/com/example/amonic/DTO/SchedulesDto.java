package com.example.amonic.DTO;

import java.time.LocalDate;

public class SchedulesDto {

	private Long aircraft;

	private Long route;

	private LocalDate date;

	private String time;

	private Double economyPrice;

	private Boolean confirmed;

	private Integer flightNumber;

	public Long getAircraft() {
		return aircraft;
	}

	public void setAircraft(Long aircraft) {
		this.aircraft = aircraft;
	}

	public Long getRoute() {
		return route;
	}

	public void setRoute(Long route) {
		this.route = route;
	}

	public Double getEconomyPrice() {
		return economyPrice;
	}

	public void setEconomyPrice(Double economyPrice) {
		this.economyPrice = economyPrice;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	



}
