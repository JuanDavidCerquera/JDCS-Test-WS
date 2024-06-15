package com.example.amonic.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity(name = "airports")
public class Airports extends ABaseEntity{
	  @Column(name = "iata_code", nullable = false)
	    private String iataCode;
	  
	  @Column(name = "name", nullable = false)
	    private String name;

	   @ManyToOne(fetch = FetchType.EAGER, optional = false )
	    @JoinColumn(name = "country_id", nullable = false)
	    private Countries country;


	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Countries getCountry() {
		return country;
	}

	public void setCountry(Countries country) {
		this.country = country;
	}  
}
