package com.example.amonic.Service.Operacional.AirLine;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.DTO.Operacional.Stockpile.IStockpileDto;
import com.example.amonic.DTO.Operacional.Stockpile.StockpileFilter;
import com.example.amonic.Entity.Operacional.Schedules;
import com.example.amonic.IRepository.Base.IBaseRepository;
import com.example.amonic.IRepository.Operacional.AirLine.ISchedulesRepository;
import com.example.amonic.IService.Operacional.AirLine.ISchedulesService;
import com.example.amonic.Service.Base.ABaseService;

@Service
public class SchedulesService extends ABaseService<Schedules> implements ISchedulesService {

	@Override
	protected IBaseRepository<Schedules, Long> getRepository() {
		return repo;
	}

	@Autowired
	private ISchedulesRepository repo;

	@Override
	public List<Schedules> getByFilter(
			Long aircraftId,
			Long routeId,
			LocalDate date,
			String time,
			Double economyPrice,
			Boolean confirmed,
			Integer flightNumber) {
		return repo.getByFilter(
				aircraftId,
				routeId,
				date,
				time,
				economyPrice,
				confirmed,
				flightNumber);
	}

	@Override
	public List<IStockpileDto> getStockpile(StockpileFilter filters) {
		
		return repo.getStockpile(filters.getId(), filters.getOrigen(), filters.getDestino(), filters.getFechaSalida(), filters.getFechaLlegada(), filters.getTipocabina(), filters.getSeatdis());
	}
}
