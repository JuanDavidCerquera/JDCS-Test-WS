package com.example.amonic.IRepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.amonic.DTO.FlightDto;
import com.example.amonic.Entity.Countries;

@Repository
public interface ICountriesRepository extends IBaseRepository<Countries, Long>{

	@Query(value="select\r\n"
			+ "schedules.id, \r\n"
			+ " routes.departure_airports_id as origen,\r\n"
			+ " routes.arrival_airports_id as destino,\r\n"
			+ " schedules.date as fecha,\r\n"
			+ "schedules.time as hora,\r\n"
			+ "schedules.flight_number as numerovuelo,\r\n"
			+ "schedules.economy_price as preciocabina,\r\n"
			+ "aircrafts.economy_seats as  ecoseat,\r\n"
			+ "aircrafts.business_seats as  busseat\r\n"
			+ "from schedules\r\n"
			+ "INNER JOIN routes on schedules.route_id = routes.id\r\n"
			+ "INNER JOIN aircrafts on aircrafts.id =  schedules.aircraft_id \r\n"
			+ "where \r\n"
			+ "routes.departure_airports_id like CONCAT('%', :origen, '%')  and\r\n"
			+ "routes.arrival_airports_id like CONCAT('%', :destino, '%')  and\r\n"
			+ "schedules.date between :salida  AND :llegada \r\n"
			+ ";", nativeQuery = true)
	List<FlightDto> getflightfilter(
			@Param("origen") String origen,
			@Param("destino") String destino,
			@Param("salida") LocalDate salida,
			@Param("llegada") LocalDate llegada);
	
	

	@Query(value="select\r\n"
			+ "schedules.id, \r\n"
			+ " routes.departure_airports_id as origen,\r\n"
			+ " routes.arrival_airports_id as destino,\r\n"
			+ " schedules.date as fecha,\r\n"
			+ "schedules.time as hora,\r\n"
			+ "schedules.flight_number as numerovuelo,\r\n"
			+ "schedules.economy_price as preciocabina,\r\n"
			+ "aircrafts.economy_seats as  ecoseat,\r\n"
			+ "aircrafts.business_seats as  busseat\r\n"
			+ "from schedules\r\n"
			+ "INNER JOIN routes on schedules.route_id = routes.id\r\n"
			+ "INNER JOIN aircrafts on aircrafts.id =  schedules.aircraft_id \r\n"
			+ "where \r\n"
			+ "schedules.id= :id"
			
	, nativeQuery = true)
	List<FlightDto> getflight(@Param("id") Long id);
}
