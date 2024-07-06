package com.example.amonic.IRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.amonic.Entity.Schedules;

@Repository
public interface ISchedulesRepository extends IBaseRepository<Schedules, Long> {

	@Query(value = "SELECT * FROM schedules " +
	        "WHERE (:aircraftId IS NULL OR aircraft_id = :aircraftId OR :aircraftId = 0) " +
	        "AND (:routeId IS NULL OR route_id = :routeId OR :routeId = 0) " +
	        "AND (:date IS NULL OR date = :date) " +
	        "AND (:time IS NULL OR time = :time) " +
	        "AND (:economyPrice IS NULL OR economy_price = :economyPrice OR :economyPrice = 0) " +
	        "AND (:confirmed IS NULL OR confirmed = :confirmed) " +
	        "AND (:flightNumber IS NULL OR flight_number = :flightNumber OR :flightNumber = 0)", nativeQuery = true)
	List<Schedules> getByFilter(
	        @Param("aircraftId") Long aircraftId,
	        @Param("routeId") Long routeId,
	        @Param("date") LocalDate date,
	        @Param("time") String time,
	        @Param("economyPrice") Double economyPrice,
	        @Param("confirmed") Boolean confirmed,
	        @Param("flightNumber") Integer flightNumber);

}
