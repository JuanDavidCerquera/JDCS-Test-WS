package com.example.amonic.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.DTO.SchedulesDto;

import com.example.amonic.Entity.Schedules;
import com.example.amonic.IService.ISchedulesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/schedules")
public class SchedulesController extends ABaseController<Schedules, ISchedulesService> {

	protected SchedulesController(ISchedulesService service) {
		super(service, "schedules");
	}

	@PostMapping("/filters")
	public ResponseEntity<List<Schedules>> getByFilters(@RequestBody SchedulesDto filters) {
		try {
			return ResponseEntity.ok(
					service.getByFilter(
							filters.getAircraft(),
							filters.getAircraft(),
							filters.getDate(),
							filters.getTime(),
							filters.getEconomyPrice(),
							filters.getConfirmed(),
							filters.getFlightNumber()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}
}
