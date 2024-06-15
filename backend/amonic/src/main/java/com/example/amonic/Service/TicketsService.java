package com.example.amonic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Tickets;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IRepository.ITicketsRepository;
import com.example.amonic.IService.ITicketsService;

@Service
public class TicketsService extends ABaseService<Tickets> implements ITicketsService{

	@Override
	protected IBaseRepository<Tickets, Long> getRepository() {
		return repo;
	}
	
	@Autowired
	private ITicketsRepository repo;
}
