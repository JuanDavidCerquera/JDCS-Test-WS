package com.example.amonic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
