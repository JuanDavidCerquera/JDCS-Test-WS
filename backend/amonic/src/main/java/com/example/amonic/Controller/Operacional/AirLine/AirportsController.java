package com.example.amonic.Controller.Operacional.AirLine;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Controller.Base.ABaseController;
import com.example.amonic.DTO.Operacional.AirLine.AirportsDto;
import com.example.amonic.Entity.Operacional.Airports;
import com.example.amonic.IService.Operacional.AirLine.IAirportsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/airports")
public class AirportsController extends ABaseController<Airports, IAirportsService> {

	protected AirportsController(IAirportsService service) {
		super(service, "airports");
	}

	@PostMapping("/filters")
	public ResponseEntity<List<Airports>> getByFilters(@RequestBody AirportsDto filters) {
		try {
			return ResponseEntity.ok(
					service.getByFilter(
							filters.getIataCode(),
							filters.getName(),
							filters.getCountry()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}
}
