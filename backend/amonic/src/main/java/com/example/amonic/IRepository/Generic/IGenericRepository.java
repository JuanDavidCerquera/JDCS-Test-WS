package com.example.amonic.IRepository.Generic;

import java.util.List;
import java.util.Map;

public interface IGenericRepository {
	  List<Map<String, Object>> findCustomData(String query);
}
