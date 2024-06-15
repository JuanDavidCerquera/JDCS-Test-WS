package com.example.amonic.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Entity.Offices;
import com.example.amonic.IService.IOfficeService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("1v/api/offices")
public class OfficeController extends ABaseController<Offices, IOfficeService>{

	protected OfficeController(IOfficeService service) {
		super(service, "offices");
	}

}
