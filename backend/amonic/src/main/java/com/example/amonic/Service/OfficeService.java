package com.example.amonic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Offices;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IRepository.IOfficeRepository;
import com.example.amonic.IService.IOfficeService;


@Service
public class OfficeService extends ABaseService<Offices> implements IOfficeService{

	@Override
	protected IBaseRepository<Offices, Long> getRepository() {
		return repo;
	}
	
	@Autowired
	private IOfficeRepository repo;
}
