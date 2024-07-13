package com.example.amonic.Service.Operacional.AirLine;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.DTO.FlightDto;
import com.example.amonic.DTO.FlightDto2;
import com.example.amonic.Entity.Operacional.Countries;
import com.example.amonic.IRepository.Base.IBaseRepository;
import com.example.amonic.IRepository.Operacional.AirLine.ICountriesRepository;
import com.example.amonic.IService.Operacional.AirLine.ICountriesService;
import com.example.amonic.Service.Base.ABaseService;

@Service
public class CountriesService extends ABaseService<Countries> implements ICountriesService {

	@Override
	protected IBaseRepository<Countries, Long> getRepository() {
		return repo;
	}

	@Autowired
	private ICountriesRepository repo;

	@Override
	public List<FlightDto2> getflightfilter(String origen, String destino, LocalDate salida, LocalDate llegada, String tipo_cabina) {
		return repo.getflightfilter(origen, destino, salida, llegada, tipo_cabina);
	}

	@Override
	public List<FlightDto> getflight(Long id) {
		return repo.getflight(id);
	}

	@Override
	public List<FlightDto> getflightfilterOptional(String origen, String destino, LocalDate salida, LocalDate llegada) {
		return repo.getflightfilterOptional(origen, destino, salida, llegada);
	}
}
