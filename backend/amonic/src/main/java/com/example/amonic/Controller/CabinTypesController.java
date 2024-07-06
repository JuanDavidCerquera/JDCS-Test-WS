package com.example.amonic.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.DTO.CabinTypesDto;
import com.example.amonic.Entity.CabinTypes;
import com.example.amonic.IService.ICabinTypesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("1v/api/cabinTypes")
public class CabinTypesController extends ABaseController<CabinTypes, ICabinTypesService> {

    protected CabinTypesController(ICabinTypesService service) {
        super(service, "cabinTypes");
    }

    @PostMapping("/filters")
    public ResponseEntity<List<CabinTypes>> getByFilters(@RequestBody CabinTypesDto filters) {
        try {
            return ResponseEntity.ok(
                    service.getByFilter(
                            filters.getName()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

}
