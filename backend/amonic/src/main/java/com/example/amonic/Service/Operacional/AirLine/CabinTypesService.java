package com.example.amonic.Service.Operacional.AirLine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Operacional.CabinTypes;
import com.example.amonic.IRepository.Base.IBaseRepository;
import com.example.amonic.IRepository.Operacional.AirLine.ICabinTypesRepository;
import com.example.amonic.IService.Operacional.AirLine.ICabinTypesService;
import com.example.amonic.Service.Base.ABaseService;

@Service
public class CabinTypesService extends ABaseService<CabinTypes> implements ICabinTypesService {

	@Override
	protected IBaseRepository<CabinTypes, Long> getRepository() {
		return repo;
	}

	@Autowired
	private ICabinTypesRepository repo;

	@Override
	public List<CabinTypes> getByFilter(String name) {
		return repo.getByFilter(name);
	}
}
