package com.example.amonic.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Schedules;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IRepository.ISchedulesRepository;
import com.example.amonic.IService.ISchedulesService;

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
}
