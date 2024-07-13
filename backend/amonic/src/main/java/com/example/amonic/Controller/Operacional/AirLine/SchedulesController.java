package com.example.amonic.Controller.Operacional.AirLine;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Controller.Base.ABaseController;
import com.example.amonic.DTO.Operacional.AirLine.SchedulesDto;
import com.example.amonic.DTO.Operacional.Stockpile.IStockpileDto;
import com.example.amonic.DTO.Operacional.Stockpile.StockpileFilter;
import com.example.amonic.Entity.Operacional.Schedules;
import com.example.amonic.IService.Operacional.AirLine.ISchedulesService;

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
	

	@PostMapping("/stockpile/filter")
	public ResponseEntity<List<IStockpileDto>> getByFilters(@RequestBody StockpileFilter filters) {
		try {
			return ResponseEntity.ok(service.getStockpile(filters));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}
}
