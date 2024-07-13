package com.example.amonic.IService.Operacional.AirLine;

import java.util.List;

import com.example.amonic.Entity.Operacional.Routes;
import com.example.amonic.IService.Base.IBaseService;

public interface IRoutesService extends IBaseService<Routes> {

	List<Routes> getbyfilter(
			Long origen,
			Long destino,
			Double flight,
			Double distance);

}
