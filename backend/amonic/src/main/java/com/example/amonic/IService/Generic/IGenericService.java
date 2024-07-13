package com.example.amonic.IService.Generic;

import java.util.List;
import java.util.Map;

import com.example.amonic.DTO.Generic.GenericDto;

public interface IGenericService {

	List<Map<String, Object>> getGeneric(GenericDto filter) throws Exception;
	
	
}
