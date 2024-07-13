package com.example.amonic.Controller.Operacional.Stockpile;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.IService.Operacional.Stockpile.IStockpileService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/Stockpile")
public class StockpileController {

	@Autowired
	private IStockpileService service;
	
	@GetMapping("/filters")
	public ResponseEntity<List<Map<String, Object>>> getByFilters() {
		try {
			return ResponseEntity.ok(service.getStockpile());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}

	
}
