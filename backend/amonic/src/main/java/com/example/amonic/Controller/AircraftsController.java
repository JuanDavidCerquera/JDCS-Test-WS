package com.example.amonic.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.DTO.AircraftDto;
import com.example.amonic.Entity.Aircrafts;
import com.example.amonic.IService.IAircraftsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/aircrafts")
public class AircraftsController extends ABaseController<Aircrafts, IAircraftsService> {

	protected AircraftsController(IAircraftsService service) {
		super(service, "aircrafts");
	}

	@PostMapping("/filters")
	public ResponseEntity<List<Aircrafts>> getByFilters(@RequestBody AircraftDto filters) {
		try {
			return ResponseEntity.ok(
					service.getByFilter(
							filters.getName(),
							filters.getMakeModel(),
							filters.getTotalSeats(),
							filters.getEconomySeats(),
							filters.getBusinessSeats()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}

}
