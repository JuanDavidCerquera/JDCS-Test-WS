package com.example.amonic.IService;

import java.util.List;

import com.example.amonic.Entity.Aircrafts;

public interface IAircraftsService extends IBaseService<Aircrafts> {

	List<Aircrafts> getByFilter(
			String name,
			String makeModel,
			Integer totalSeats,
			Integer economySeats,
			Integer businessSeats);
}
