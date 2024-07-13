package com.example.amonic.Controller.Operacional.AirLine;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Controller.Base.ABaseController;
import com.example.amonic.DTO.Operacional.AirLine.AircraftDto;
import com.example.amonic.Entity.Operacional.Aircrafts;
import com.example.amonic.IService.Operacional.AirLine.IAircraftsService;

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
