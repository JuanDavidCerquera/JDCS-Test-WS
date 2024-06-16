package com.example.amonic.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.DTO.FlightDto;
import com.example.amonic.Entity.Countries;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IRepository.ICountriesRepository;
import com.example.amonic.IService.ICountriesService;

@Service
public class CountriesService extends ABaseService<Countries> implements ICountriesService{

	@Override
	protected IBaseRepository<Countries, Long> getRepository() {
		return repo;
	}

	@Autowired
	private ICountriesRepository repo;

	
	@Override
	public List<FlightDto> getflightfilter(String origen, String destino, LocalDate salida, LocalDate llegada) {
		return repo.getflightfilter(origen,  destino,  salida,  llegada);
	}


	@Override
	public List<FlightDto> getflight( Long id) {
		return repo.getflight(id);
	}
}
