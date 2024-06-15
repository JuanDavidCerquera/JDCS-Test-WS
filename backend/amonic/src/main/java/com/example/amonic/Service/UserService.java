package com.example.amonic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.User;
import com.example.amonic.IRepository.IBaseRepository;
import com.example.amonic.IRepository.IUserRepository;
import com.example.amonic.IService.IUserService;

@Service
public class UserService extends ABaseService<User> implements IUserService{

	@Override
	protected IBaseRepository<User, Long> getRepository() {
		return repo;
	}
	@Autowired
	private IUserRepository repo;
	
}
