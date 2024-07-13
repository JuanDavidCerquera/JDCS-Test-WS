package com.example.amonic.IService.Operacional.AirLine;

import java.util.List;

import com.example.amonic.Entity.Operacional.CabinTypes;
import com.example.amonic.IService.Base.IBaseService;

public interface ICabinTypesService extends IBaseService<CabinTypes> {

	List<CabinTypes> getByFilter(String name);
}
