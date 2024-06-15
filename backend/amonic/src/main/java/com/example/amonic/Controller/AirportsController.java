package com.example.amonic.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Entity.Airports;
import com.example.amonic.IService.IAirportsService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("1v/api/airports")
public class AirportsController extends ABaseController<Airports, IAirportsService>{

	protected AirportsController(IAirportsService service) {
		super(service, "airports");
	}

}
