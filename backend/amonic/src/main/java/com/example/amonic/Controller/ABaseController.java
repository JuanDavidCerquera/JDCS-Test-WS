package com.example.amonic.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.amonic.DTO.ResponseDto;
import com.example.amonic.Entity.ABaseEntity;
import com.example.amonic.IService.IBaseService;

public class ABaseController<T extends ABaseEntity, S extends IBaseService<T>> {

	protected S service;
	protected String entityName;

	protected ABaseController(S service, String entityName) {
		this.service = service;
		this.entityName = entityName;
	}

	@GetMapping
	private ResponseEntity<ResponseDto<List<T>>> all() {
		try {
			return ResponseEntity.ok(new ResponseDto<List<T>>("datos obtenidos", service.all(), true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ResponseDto<>(e.getMessage(), null, null));
		}
	}

	@GetMapping("{id}")
	private ResponseEntity<ResponseDto<Optional<T>>> findById(@PathVariable Long id) {
		try {
			Optional<T> entity = service.findById(id);
			return ResponseEntity.ok(new ResponseDto<Optional<T>>("datos obtenidos", entity, true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ResponseDto<>(e.getMessage(), null, null));
		}
	}

	@PostMapping
	private ResponseEntity<ResponseDto<T>> save(@RequestBody T entity) {
		try {
			return ResponseEntity.ok(new ResponseDto<T>("datos obtenidos", service.save(entity), true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ResponseDto<>(e.getMessage(), null, null));
		}
	}

	@PutMapping("{id}")
	private ResponseEntity<ResponseDto<T>> save(@PathVariable Long id, @RequestBody T entity) {
		try {
			service.update(id, entity);
			return ResponseEntity.ok(new ResponseDto<T>("datos obtenidos", null, true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ResponseDto<>(e.getMessage(), null, null));
		}
	}

	@DeleteMapping("{id}")
	private ResponseEntity<ResponseDto<T>> delete(@PathVariable Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok(new ResponseDto<T>("datos obtenidos", null, true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ResponseDto<>(e.getMessage(), null, null));
		}
	}
}
