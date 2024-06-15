package com.example.amonic.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Entity.Countries;
import com.example.amonic.IService.ICountriesService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("1v/api/countries")
public class CountriesController extends ABaseController<Countries, ICountriesService>{

	protected CountriesController(ICountriesService service) {
		super(service, "countries");
	}

}
