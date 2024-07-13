package com.example.amonic.Service.Operacional.AirLine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.Entity.Operacional.User;
import com.example.amonic.IRepository.Base.IBaseRepository;
import com.example.amonic.IRepository.Operacional.AirLine.IUserRepository;
import com.example.amonic.IService.Operacional.AirLine.IUserService;
import com.example.amonic.Service.Base.ABaseService;

@Service
public class UserService extends ABaseService<User> implements IUserService {

	@Override
	protected IBaseRepository<User, Long> getRepository() {
		return repo;
	}

	@Autowired
	private IUserRepository repo;

	@Override
	public List<User> getByFilter(
			String email,
			String password,
			String firstName,
			String lastName,
			String birthdate,
			String state,
			Long roleId,
			Long officeId) {

		return repo.getByFilter(
				email,
				password,
				firstName,
				lastName,
				birthdate,
				state,
				roleId,
				officeId);
	}

}
