package com.example.amonic.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Entity.Tickets;
import com.example.amonic.IService.ITicketsService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("1v/api/tickets")
public class TicketsController extends ABaseController<Tickets, ITicketsService>{

	protected TicketsController(ITicketsService service) {
		super(service, "tickets");
	}

}
