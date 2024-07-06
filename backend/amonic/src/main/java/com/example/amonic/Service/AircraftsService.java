package com.example.amonic.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Aircrafts;
import com.example.amonic.IRepository.IAircraftsRepository;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IService.IAircraftsService;

@Service
public class AircraftsService extends ABaseService<Aircrafts> implements IAircraftsService {

	@Override
	protected IBaseRepository<Aircrafts, Long> getRepository() {
		return repo;
	}

	@Autowired
	private IAircraftsRepository repo;

	@Override
	public List<Aircrafts> getByFilter(
			String name,
			String makeModel,
			Integer totalSeats,
			Integer economySeats,
			Integer businessSeats) {
		return repo.getByFilter(
				name,
				makeModel,
				totalSeats,
				economySeats,
				businessSeats);
	}

}
