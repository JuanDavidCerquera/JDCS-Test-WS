package com.example.amonic.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Routes;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IRepository.IRoutesRepository;
import com.example.amonic.IService.IRoutesService;

@Service
public class RoutesService extends ABaseService<Routes> implements IRoutesService {

	@Override
	protected IBaseRepository<Routes, Long> getRepository() {
		return repo;
	}

	@Autowired
	private IRoutesRepository repo;

	@Override
	public List<Routes> getbyfilter(Long origen, Long destino, Double flight, Double distance) {
		return repo.getbyfilter(origen, destino, flight, distance);
	}
}
