package com.example.amonic.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Entity.User;
import com.example.amonic.IService.IUserService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("1v/api/user")
public class UserController extends ABaseController<User, IUserService>{

	protected UserController(IUserService service) {
		super(service, "user");
	}

}
