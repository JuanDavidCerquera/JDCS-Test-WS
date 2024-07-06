package com.example.amonic.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.DTO.RoutesDto;
import com.example.amonic.Entity.Routes;
import com.example.amonic.IService.IRoutesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/routes")
public class RoutesController extends ABaseController<Routes, IRoutesService> {

	protected RoutesController(IRoutesService service) {
		super(service, "routes");
	}

	@PostMapping("/filters")
	public ResponseEntity<List<Routes>> getByFilters(@RequestBody RoutesDto filters) {
		try {
			return ResponseEntity.ok(
					service.getbyfilter(
							filters.getDepartureAirportsId(),
							filters.getArrivalAirportsId(),
							filters.getFlightTime(),
							filters.getDistance()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}

}
