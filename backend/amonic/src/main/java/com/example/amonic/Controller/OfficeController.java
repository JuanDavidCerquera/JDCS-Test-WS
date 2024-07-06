package com.example.amonic.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.DTO.OfficesDto;

import com.example.amonic.Entity.Offices;
import com.example.amonic.IService.IOfficeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/offices")
public class OfficeController extends ABaseController<Offices, IOfficeService> {

	protected OfficeController(IOfficeService service) {
		super(service, "offices");
	}

	@PostMapping("/filters")
	public ResponseEntity<List<Offices>> getByFilters(@RequestBody OfficesDto filters) {
		try {
			return ResponseEntity.ok(
					service.getByFilter(
							filters.getTitle(),
							filters.getPhone(),
							filters.getContact(),
							filters.getCountry()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}

}
