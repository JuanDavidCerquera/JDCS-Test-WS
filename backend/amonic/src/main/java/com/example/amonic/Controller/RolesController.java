package com.example.amonic.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Entity.Roles;
import com.example.amonic.IService.IRolesService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("1v/api/roles")
public class RolesController extends ABaseController<Roles, IRolesService> {

	protected RolesController(IRolesService service) {
		super(service, "roles");
	}

}
