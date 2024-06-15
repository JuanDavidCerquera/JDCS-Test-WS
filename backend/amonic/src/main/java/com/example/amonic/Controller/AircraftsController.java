package com.example.amonic.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Entity.Aircrafts;
import com.example.amonic.IService.IAircraftsService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("1v/api/aircrafts")
public class AircraftsController extends ABaseController<Aircrafts, IAircraftsService>{

	protected AircraftsController(IAircraftsService service) {
		super(service, "aircrafts");
	}

}
