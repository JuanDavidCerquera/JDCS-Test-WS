package com.example.amonic.IService;

import java.util.List;

import com.example.amonic.Entity.Airports;

public interface IAirportsService extends IBaseService<Airports> {
	List<Airports> getByFilter(
			String iataCode,
			String name,
			Long country);
}
