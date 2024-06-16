package com.example.amonic.IService;

import java.time.LocalDate;
import java.util.List;


import com.example.amonic.DTO.FlightDto;
import com.example.amonic.Entity.Countries;

public interface ICountriesService extends IBaseService<Countries>{

	
	List<FlightDto> getflight( Long id);
	
	List<FlightDto> getflightfilter(	String origen,String destino, LocalDate salida,LocalDate llegada);
}
