package com.example.amonic.IService;

import java.util.List;
import java.util.Optional;

import com.example.amonic.Entity.ABaseEntity;

public interface IBaseService<T extends ABaseEntity> {
	
	List<T> all() throws Exception;
	Optional<T> findById(Long id)throws Exception;
	T save(T entity) throws Exception;
	void update(Long id, T entity)throws Exception;
	void delete(Long id)throws Exception;
	
	
}
