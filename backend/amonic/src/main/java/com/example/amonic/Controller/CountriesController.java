package com.example.amonic.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.DTO.FlightDto;
import com.example.amonic.DTO.ResponseDto;
import com.example.amonic.DTO.flight;
import com.example.amonic.DTO.paramFlicht;
import com.example.amonic.Entity.Countries;
import com.example.amonic.IService.ICountriesService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("1v/api/countries")
public class CountriesController extends ABaseController<Countries, ICountriesService>{

	protected CountriesController(ICountriesService service) {
		super(service, "countries");
	}

	@PostMapping("/flight/filter")
	private ResponseEntity<ResponseDto<List<FlightDto>>> getflightfilter(@RequestBody paramFlicht filter){
		try {
			return ResponseEntity.ok(new ResponseDto<List<FlightDto>>("datos obtenidos", service.getflightfilter(filter.getOrigen(), filter.getDestino(), filter.getSalida(),filter.getLlegada()), true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ResponseDto<>(e.getMessage(), null, null));
		}
	}
	@GetMapping("/flight/{id}")
	private ResponseEntity<ResponseDto<List<FlightDto>>> getFlight(@PathVariable Long id){
		try {
			return ResponseEntity.ok(new ResponseDto<List<FlightDto>>("datos obtenidos", service.getflight(id), true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ResponseDto<>(e.getMessage(), null, null));
		}
	}
}
