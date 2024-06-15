package com.example.amonic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Roles;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IRepository.IRolesRepository;
import com.example.amonic.IService.IRolesService;

@Service
public class RolesService extends ABaseService<Roles> implements IRolesService{

	@Override
	protected IBaseRepository<Roles, Long> getRepository() {
		return repo;
	}
	
	@Autowired
	private IRolesRepository repo;
	
	

}
