package com.example.amonic.Controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Entity.Roles;
import com.example.amonic.IService.IRolesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/roles")
public class RolesController extends AGenericController<Roles, IRolesService> {

	protected RolesController(IRolesService service) {
		super(service, "roles", "hola");
	}
/*
	@PostMapping("/filters")
	public ResponseEntity<List<Roles>> getByFilters(@RequestBody Roles filters) {
		try {
			return ResponseEntity.ok(
					service.getByFilter(filters));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}*/
}
