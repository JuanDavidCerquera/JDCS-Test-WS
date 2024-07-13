package com.example.amonic.IRepository.Operacional.AirLine;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.amonic.Entity.Operacional.Airports;
import com.example.amonic.IRepository.Base.IBaseRepository;

@Repository
public interface IAirportRepository extends IBaseRepository<Airports, Long> {

	@Query(value = ""
			+ " SELECT *"
			+ " FROM airports"
			+ " WHERE"
			+ "     (:iataCode IS NULL OR iata_code LIKE %:iataCode%)"
			+ " AND (:name IS NULL OR name LIKE %:name%)"
			+ " AND (:country IS NULL OR country_id = :country OR :country = 0)", nativeQuery = true)
	List<Airports> getByFilter(
			@Param("iataCode") String iataCode,
			@Param("name") String name,
			@Param("country") Long country);
}
