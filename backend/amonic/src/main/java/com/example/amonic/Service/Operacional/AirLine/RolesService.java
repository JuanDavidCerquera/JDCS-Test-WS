package com.example.amonic.Service.Operacional.AirLine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Operacional.Roles;
import com.example.amonic.IRepository.Base.IBaseRepository;
import com.example.amonic.IRepository.Operacional.AirLine.IRolesRepository;
import com.example.amonic.IService.Operacional.AirLine.IRolesService;
import com.example.amonic.Service.Base.ABaseService;

@Service
public class RolesService extends ABaseService<Roles> implements IRolesService {

	@Override
	protected IBaseRepository<Roles, Long> getRepository() {
		return repo;
	}

	@Autowired
	private IRolesRepository repo;
/*
	@Override
	public List<Roles> getByFilter(String title) {
		return repo.getByFilter(title);
	}*/

	@Override
	public List<Roles> getByFilter(Roles filters) {
		return repo.getByFilter(filters.getTitle());
	}


}
