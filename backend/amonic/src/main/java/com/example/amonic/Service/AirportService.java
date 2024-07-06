package com.example.amonic.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Airports;
import com.example.amonic.IRepository.IAirportRepository;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IService.IAirportsService;

@Service
public class AirportService extends ABaseService<Airports> implements IAirportsService {

	@Override
	protected IBaseRepository<Airports, Long> getRepository() {
		return repo;
	}

	@Autowired
	private IAirportRepository repo;

	@Override
	public List<Airports> getByFilter(String iataCode, String name, Long country) {
		return repo.getByFilter(iataCode, name, country);
	}

}
