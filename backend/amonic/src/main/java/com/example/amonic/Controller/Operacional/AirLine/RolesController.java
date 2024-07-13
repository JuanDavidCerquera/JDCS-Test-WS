package com.example.amonic.Controller.Operacional.AirLine;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Controller.Base.AGenericController;
import com.example.amonic.Entity.Operacional.Roles;
import com.example.amonic.IService.Operacional.AirLine.IRolesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/roles")
public class RolesController extends AGenericController<Roles, IRolesService> {

	protected RolesController(IRolesService service) {
		super(service, "roles");
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
