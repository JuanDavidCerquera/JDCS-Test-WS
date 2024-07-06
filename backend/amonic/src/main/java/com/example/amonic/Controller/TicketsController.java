package com.example.amonic.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.DTO.TicketsDto;

import com.example.amonic.Entity.Tickets;
import com.example.amonic.IService.ITicketsService;

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
