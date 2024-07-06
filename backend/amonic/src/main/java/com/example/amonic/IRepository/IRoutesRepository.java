package com.example.amonic.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.amonic.Entity.Routes;

@Repository
public interface IRoutesRepository extends IBaseRepository<Routes, Long> {

	@Query(value = ""
			+ " SELECT *"
			+ " FROM routes"
			+ " where"
			+ "     (:origen IS NULL OR departure_airports_id = :origen OR :origen = 0)"
			+ " AND (:destino IS NULL OR arrival_airports_id = :destino OR :destino = 0)"
			+ " AND (:flight IS NULL OR flight_time = :flight OR :flight = 0)"
			+ " AND (:distance IS NULL OR distance = :distance OR :distance = 0)", nativeQuery = true)
	List<Routes> getbyfilter(
			@Param("origen") Long origen,
			@Param("destino") Long destino,
			@Param("flight") Double flight,
			@Param("distance") Double distance);

}
