package com.example.amonic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.CabinTypes;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IRepository.ICabinTypesRepository;
import com.example.amonic.IService.ICabinTypesService;

@Service
public class CabinTypesService  extends ABaseService<CabinTypes> implements ICabinTypesService{

	@Override
	protected IBaseRepository<CabinTypes, Long> getRepository() {
		return repo;
	}

	@Autowired
	private ICabinTypesRepository repo;
}
