package com.example.amonic.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Entity.Schedules;
import com.example.amonic.IService.ISchedulesService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("1v/api/schedules")
public class SchedulesController extends ABaseController<Schedules, ISchedulesService>{

	protected SchedulesController(ISchedulesService service) {
		super(service, "schedules");
	}

}
