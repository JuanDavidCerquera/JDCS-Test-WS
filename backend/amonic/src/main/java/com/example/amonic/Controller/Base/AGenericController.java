package com.example.amonic.Controller.Base;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.amonic.DTO.Base.ResponseDto;
import com.example.amonic.Entity.Base.ABaseEntity;
import com.example.amonic.IService.Base.IBaseService;

public class AGenericController<T extends ABaseEntity, S extends IBaseService<T>> {

	protected S service;
	protected String entityName;

	protected AGenericController(S service, String entityName) {
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

	@PostMapping("/filters")
	public ResponseEntity<List<T>> getByFilters(@RequestBody T entity) {
		try {
			return ResponseEntity.ok(service.getByFilter(entity));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}
}
