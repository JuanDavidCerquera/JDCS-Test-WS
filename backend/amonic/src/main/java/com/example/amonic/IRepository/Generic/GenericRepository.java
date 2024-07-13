package com.example.amonic.IRepository.Generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class GenericRepository{
	
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	

	public List<Map<String, Object>> findCustomData(String query) {
		 String sql = query;
	        return jdbcTemplate.queryForList(sql);
	}

}
