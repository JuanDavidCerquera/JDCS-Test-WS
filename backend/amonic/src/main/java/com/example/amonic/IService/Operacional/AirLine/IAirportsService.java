package com.example.amonic.IService.Operacional.AirLine;

import java.util.List;

import com.example.amonic.Entity.Operacional.Airports;
import com.example.amonic.IService.Base.IBaseService;

public interface IAirportsService extends IBaseService<Airports> {
	List<Airports> getByFilter(
			String iataCode,
			String name,
			Long country);
}
