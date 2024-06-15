package com.example.amonic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Aircrafts;
import com.example.amonic.IRepository.IAircraftsRepository;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IService.IAircraftsService;

@Service
public class AircraftsService extends ABaseService<Aircrafts> implements IAircraftsService{

	@Override
	protected IBaseRepository<Aircrafts, Long> getRepository() {
		return repo;
	}
	
	
	@Autowired
	private IAircraftsRepository repo;

}
