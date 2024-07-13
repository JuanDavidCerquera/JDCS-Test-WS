package com.example.amonic.IService.Operacional.AirLine;

import java.util.List;

import com.example.amonic.Entity.Operacional.Aircrafts;
import com.example.amonic.IService.Base.IBaseService;

public interface IAircraftsService extends IBaseService<Aircrafts> {

	List<Aircrafts> getByFilter(
			String name,
			String makeModel,
			Integer totalSeats,
			Integer economySeats,
			Integer businessSeats);
}
