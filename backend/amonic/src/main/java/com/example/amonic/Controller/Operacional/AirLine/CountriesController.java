package com.example.amonic.Controller.Operacional.AirLine;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Controller.Base.ABaseController;
import com.example.amonic.DTO.FlightDto;
import com.example.amonic.DTO.FlightDto2;
import com.example.amonic.DTO.ParamFlight2;
import com.example.amonic.DTO.paramFlicht;
import com.example.amonic.DTO.Base.ResponseDto;
import com.example.amonic.Entity.Operacional.Countries;
import com.example.amonic.IService.Operacional.AirLine.ICountriesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/countries")
public class CountriesController extends ABaseController<Countries, ICountriesService> {

	protected CountriesController(ICountriesService service) {
		super(service, "countries");
	}

	@PostMapping("/flight/filter")
	private ResponseEntity<ResponseDto<List<FlightDto2>>> getflightfilter(@RequestBody ParamFlight2 filter) {
		try {
			return ResponseEntity
					.ok(new ResponseDto<List<FlightDto2>>("datos obtenidos", service.getflightfilter(filter.getOrigen(),
							filter.getDestino(), filter.getSalida(), filter.getLlegada(), filter.getTipo_cabina()), true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ResponseDto<>(e.getMessage(), null, null));
		}
	}

	@PostMapping("/flight/filter/Optional")
	private ResponseEntity<ResponseDto<List<FlightDto>>> getflightfilterOptional(@RequestBody paramFlicht filter) {
		try {
			return ResponseEntity
					.ok(new ResponseDto<List<FlightDto>>("datos obtenidos", service.getflightfilterOptional(
							filter.getOrigen(), filter.getDestino(), filter.getSalida(), filter.getLlegada()), true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ResponseDto<>(e.getMessage(), null, null));
		}
	}

	@GetMapping("/flight/{id}")
	private ResponseEntity<ResponseDto<List<FlightDto>>> getFlight(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(new ResponseDto<List<FlightDto>>("datos obtenidos", service.getflight(id), true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ResponseDto<>(e.getMessage(), null, null));
		}
	}
}
