package com.example.amonic.DTO;

public class AircraftDto {
	private String name;

	private String makeModel;

	private Integer totalSeats;

	private Integer economySeats;

	private Integer businessSeats;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMakeModel() {
		return makeModel;
	}

	public void setMakeModel(String makeModel) {
		this.makeModel = makeModel;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getEconomySeats() {
		return economySeats;
	}

	public void setEconomySeats(Integer economySeats) {
		this.economySeats = economySeats;
	}

	public Integer getBusinessSeats() {
		return businessSeats;
	}

	public void setBusinessSeats(Integer businessSeats) {
		this.businessSeats = businessSeats;
	}

}
