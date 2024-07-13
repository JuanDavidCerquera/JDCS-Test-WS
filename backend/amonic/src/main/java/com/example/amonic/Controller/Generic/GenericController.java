package com.example.amonic.Controller.Generic;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.DTO.Generic.GenericDto;
import com.example.amonic.IService.Generic.IGenericService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/Generic")
public class GenericController{


@Autowired
public IGenericService service;

	@PostMapping("/filters")
	public ResponseEntity<List<Map<String, Object>>> getByFilters(@RequestBody GenericDto filters) {
		try {
			return ResponseEntity.ok(service.getGeneric(filters));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}

	
	
}
