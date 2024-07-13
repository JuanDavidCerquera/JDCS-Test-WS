package com.example.amonic.Controller.Operacional.AirLine;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Controller.Base.ABaseController;
import com.example.amonic.DTO.Operacional.AirLine.TicketsDto;
import com.example.amonic.Entity.Operacional.Tickets;
import com.example.amonic.IService.Operacional.AirLine.ITicketsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/tickets")
public class TicketsController extends ABaseController<Tickets, ITicketsService> {

	protected TicketsController(ITicketsService service) {
		super(service, "tickets");
	}

	@PostMapping("/filters")
	public ResponseEntity<List<Tickets>> getByFilters(@RequestBody TicketsDto filters) {
		try {
			return ResponseEntity.ok(
					service.getByFilter(
							filters.getCabinType(),
							filters.getSchedule(),
							filters.getUser(),
							filters.getDistance(),
							filters.getFirstName(),
							filters.getLastName(),
							filters.getEmail(),
							filters.getPhone(),
							filters.getPassportNumber(),
							filters.getPassportCountryId(),
							filters.getPassportPhoto(),
							filters.getBookingReference(),
							filters.getConfirmed()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}

}
