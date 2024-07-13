package com.example.amonic.Service.Operacional.AirLine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Operacional.Routes;
import com.example.amonic.IRepository.Base.IBaseRepository;
import com.example.amonic.IRepository.Operacional.AirLine.IRoutesRepository;
import com.example.amonic.IService.Operacional.AirLine.IRoutesService;
import com.example.amonic.Service.Base.ABaseService;

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
