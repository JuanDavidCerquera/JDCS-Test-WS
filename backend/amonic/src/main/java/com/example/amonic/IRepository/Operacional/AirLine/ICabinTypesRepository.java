package com.example.amonic.IRepository.Operacional.AirLine;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.amonic.Entity.Operacional.CabinTypes;
import com.example.amonic.IRepository.Base.IBaseRepository;

@Repository
public interface ICabinTypesRepository extends IBaseRepository<CabinTypes, Long> {

	@Query(value = "SELECT * FROM cabintypes WHERE (:name IS NULL OR name LIKE %:name%)", nativeQuery = true)
	List<CabinTypes> getByFilter(@Param("name") String name);
}
