package com.example.amonic.IService.Operacional.AirLine;

import java.time.LocalDate;
import java.util.List;

import com.example.amonic.DTO.FlightDto;
import com.example.amonic.DTO.FlightDto2;
import com.example.amonic.Entity.Operacional.Countries;
import com.example.amonic.IService.Base.IBaseService;

public interface ICountriesService extends IBaseService<Countries> {

	List<FlightDto> getflight(Long id);

	List<FlightDto2> getflightfilter(String origen, String destino, LocalDate salida, LocalDate llegada, String tipo_cabina);

	List<FlightDto> getflightfilterOptional(String origen, String destino, LocalDate salida, LocalDate llegada);
}
