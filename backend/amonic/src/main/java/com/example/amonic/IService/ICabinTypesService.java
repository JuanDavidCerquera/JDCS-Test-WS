package com.example.amonic.IService;

import java.util.List;

import com.example.amonic.Entity.CabinTypes;

public interface ICabinTypesService extends IBaseService<CabinTypes> {

	List<CabinTypes> getByFilter(String name);
}
