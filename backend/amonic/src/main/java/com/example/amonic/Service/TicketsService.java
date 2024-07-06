package com.example.amonic.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Tickets;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IRepository.ITicketsRepository;
import com.example.amonic.IService.ITicketsService;

@Service
public class TicketsService extends ABaseService<Tickets> implements ITicketsService {

	@Override
	protected IBaseRepository<Tickets, Long> getRepository() {
		return repo;
	}

	@Autowired
	private ITicketsRepository repo;

	@Override
	public List<Tickets> getByFilter(
			Long cabinTypeId,
			Long scheduleId,
			Long userId,
			Double distance,
			String firstName,
			String lastName,
			String email,
			Long phone,
			Long passportNumber,
			Long passportCountryId,
			Long passportPhoto,
			Long bookingReference,
			Boolean confirmed) {
		return repo.getByFilter(
				cabinTypeId,
				scheduleId,
				userId,
				distance,
				firstName,
				lastName,
				email,
				phone,
				passportNumber,
				passportCountryId,
				passportPhoto,
				bookingReference,
				confirmed);
	}
}
