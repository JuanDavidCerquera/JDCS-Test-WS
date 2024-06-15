package com.example.amonic.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Entity.Routes;
import com.example.amonic.IService.IRoutesService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("1v/api/routes")
public class RoutesController extends ABaseController<Routes, IRoutesService>{

	protected RoutesController(IRoutesService service) {
		super(service, "routes");
	}

}
