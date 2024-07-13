package com.example.amonic.Controller.Operacional.AirLine;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Controller.Base.ABaseController;
import com.example.amonic.DTO.Operacional.AirLine.UserDto;
import com.example.amonic.Entity.Operacional.User;
import com.example.amonic.IService.Operacional.AirLine.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/user")
public class UserController extends ABaseController<User, IUserService> {

	protected UserController(IUserService service) {
		super(service, "user");
	}

	@PostMapping("/filters")
	public ResponseEntity<List<User>> getByFilters(@RequestBody UserDto filters) {
		try {
			return ResponseEntity.ok(
					service.getByFilter(
							filters.getEmail(),
							filters.getPassword(),
							filters.getFirstName(),
							filters.getLastName(),
							filters.getBirthdate(),
							filters.getState(),
							filters.getRolesId(),
							filters.getOfficeId()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}
}
