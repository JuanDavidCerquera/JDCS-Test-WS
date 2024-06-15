package com.example.amonic.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Entity.CabinTypes;
import com.example.amonic.IService.ICabinTypesService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("1v/api/cabinTypes")
public class CabinTypesController extends ABaseController<CabinTypes, ICabinTypesService>{

	protected CabinTypesController(ICabinTypesService service) {
		super(service, "cabinTypes");
	}

}
