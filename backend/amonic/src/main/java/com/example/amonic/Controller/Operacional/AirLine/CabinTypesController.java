package com.example.amonic.Controller.Operacional.AirLine;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amonic.Controller.Base.ABaseController;
import com.example.amonic.DTO.Operacional.AirLine.CabinTypesDto;
import com.example.amonic.Entity.Operacional.CabinTypes;
import com.example.amonic.IService.Operacional.AirLine.ICabinTypesService;

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
