package com.example.amonic.Service.Operacional.AirLine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Operacional.Airports;
import com.example.amonic.IRepository.Base.IBaseRepository;
import com.example.amonic.IRepository.Operacional.AirLine.IAirportRepository;
import com.example.amonic.IService.Operacional.AirLine.IAirportsService;
import com.example.amonic.Service.Base.ABaseService;

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
