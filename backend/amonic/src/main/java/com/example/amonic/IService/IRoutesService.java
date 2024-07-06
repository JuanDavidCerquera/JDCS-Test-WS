package com.example.amonic.IService;

import java.util.List;

import com.example.amonic.Entity.Routes;

public interface IRoutesService extends IBaseService<Routes> {

	List<Routes> getbyfilter(
			Long origen,
			Long destino,
			Double flight,
			Double distance);

}
