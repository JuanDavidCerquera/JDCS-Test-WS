package com.example.amonic.IRepository.Operacional.AirLine;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.amonic.Entity.Operacional.Aircrafts;
import com.example.amonic.IRepository.Base.IBaseRepository;

@Repository
public interface IAircraftsRepository extends IBaseRepository<Aircrafts, Long> {

	@Query(value = ""
			+ " SELECT *"
			+ " FROM aircrafts"
			+ " WHERE"
			+ "     (:name IS NULL OR name LIKE %:name%)"
			+ " AND (:makeModel IS NULL OR make_model LIKE %:makeModel%)"
			+ " AND (:totalSeats IS NULL OR total_seats = :totalSeats OR :totalSeats = 0)"
			+ " AND (:economySeats IS NULL OR economy_seats = :economySeats OR :economySeats = 0)"
			+ " AND (:businessSeats IS NULL OR business_seats = :businessSeats OR :businessSeats = 0)", nativeQuery = true)
	List<Aircrafts> getByFilter(
			@Param("name") String name,
			@Param("makeModel") String makeModel,
			@Param("totalSeats") Integer totalSeats,
			@Param("economySeats") Integer economySeats,
			@Param("businessSeats") Integer businessSeats);
}
