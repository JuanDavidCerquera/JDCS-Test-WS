package com.example.amonic.IRepository.Operacional.AirLine;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.amonic.DTO.FlightDto;
import com.example.amonic.DTO.FlightDto2;
import com.example.amonic.Entity.Operacional.Countries;
import com.example.amonic.IRepository.Base.IBaseRepository;

@Repository
public interface ICountriesRepository extends IBaseRepository<Countries, Long> {

	@Query(value = "SELECT\r\n"
			+ "    schedules.id, \r\n"
			+ "    origen.name AS origen,\r\n"
			+ "    destino.name AS destino,\r\n"
			+ "    schedules.date AS fecha,\r\n"
			+ "    schedules.time AS hora,\r\n"
			+ "    schedules.flight_number AS numerovuelo,\r\n"
			+ "    schedules.economy_price AS preciocabina,\r\n"
			+ "    aircrafts.economy_seats AS ecoseat,\r\n"
			+ "    aircrafts.business_seats AS busseat,\r\n"
			+ "    COUNT(tck.id) AS asientosOcupados,\r\n"
			+ "    CASE\r\n"
			+ "        WHEN tck.cabin_types_id = 1 THEN aircrafts.economy_seats - COUNT(tck.id) \r\n"
			+ "        WHEN tck.cabin_types_id = 2 THEN aircrafts.business_seats - COUNT(tck.id)\r\n"
			+ "    END AS seatdis\r\n"
			+ "FROM schedules\r\n"
			+ "INNER JOIN routes ON schedules.route_id = routes.id\r\n"
			+ "INNER JOIN airports AS origen ON origen.id = routes.departure_airports_id\r\n"
			+ "INNER JOIN airports AS destino ON destino.id = routes.arrival_airports_id\r\n"
			+ "INNER JOIN aircrafts ON aircrafts.id = schedules.aircraft_id \r\n"
			+ "LEFT JOIN tickets AS tck ON schedules.id = tck.schedule_id AND tck.cabin_types_id = :tipo_cabina\r\n"
			+ "WHERE \r\n"
			+ "    (:origen IS NULL OR routes.departure_airports_id LIKE CONCAT('%', :origen, '%')) AND\r\n"
			+ "    (:destino IS NULL OR routes.arrival_airports_id LIKE CONCAT('%', :destino, '%')) AND\r\n"
			+ "    (:salida IS NULL OR schedules.date >= :salida) AND\r\n"
			+ "    (:salida IS NULL OR schedules.date <= COALESCE(:llegada, :salida))\r\n"
			+ "GROUP BY\r\n"
			+ "    schedules.id, origen.name, destino.name, schedules.date, schedules.time, schedules.flight_number,\r\n"
			+ "    schedules.economy_price, aircrafts.economy_seats, aircrafts.business_seats, tck.cabin_types_id\r\n"
			+ "\r\n"
			+ "HAVING\r\n"
			+ "    (CASE\r\n"
			+ "        WHEN tck.cabin_types_id = 1 THEN aircrafts.economy_seats - COUNT(tck.id) \r\n"
			+ "        WHEN tck.cabin_types_id = 2 THEN aircrafts.business_seats - COUNT(tck.id)\r\n"
			+ "    END) > 0\r\n"
			+ "    OR \r\n"
			+ "    (CASE\r\n"
			+ "        WHEN tck.cabin_types_id = 1 THEN aircrafts.economy_seats - COUNT(tck.id) \r\n"
			+ "        WHEN tck.cabin_types_id = 2 THEN aircrafts.business_seats - COUNT(tck.id)\r\n"
			+ "    END) IS NULL\r\n"
			+ "    \r\n"
			+ "    ORDER BY\r\n"
			+ "    schedules.id;\r\n"
			+ "", nativeQuery = true)
	List<FlightDto2> getflightfilter(
			@Param("origen") String origen,
			@Param("destino") String destino,
			@Param("salida") LocalDate salida,
			@Param("llegada") LocalDate llegada,
			@Param("tipo_cabina") String tipo_cabina);

	@Query(value = "select\r\n"
			+ "schedules.id, \r\n"
			+ "origen.name as origen,\r\n"
			+ "destino.name as destino,\r\n"
			+ " schedules.date as fecha,\r\n"
			+ "schedules.time as hora,\r\n"
			+ "schedules.flight_number as numerovuelo,\r\n"
			+ "schedules.economy_price as preciocabina,\r\n"
			+ "aircrafts.economy_seats as  ecoseat,\r\n"
			+ "aircrafts.business_seats as  busseat\r\n"
			+ "from schedules\r\n"
			+ "INNER JOIN routes on schedules.route_id = routes.id\r\n"
			+ "INNER JOIN airports as origen ON origen.id = routes.departure_airports_id\r\n"
			+ "INNER JOIN airports as destino ON destino.id = routes.arrival_airports_id\r\n"
			+ "INNER JOIN aircrafts on aircrafts.id =  schedules.aircraft_id \r\n"
			+ "where \r\n"
			+ "schedules.id= :id"

			, nativeQuery = true)
	List<FlightDto> getflight(@Param("id") Long id);

	@Query(value = "select\r\n"
			+ "schedules.id, \r\n"
			+ " origen.name as origen,\r\n"
			+ " destino.name as destino,\r\n"
			+ " schedules.date as fecha,\r\n"
			+ "schedules.time as hora,\r\n"
			+ "schedules.flight_number as numerovuelo,\r\n"
			+ "schedules.economy_price as preciocabina,\r\n"
			+ "aircrafts.economy_seats as  ecoseat,\r\n"
			+ "aircrafts.business_seats as  busseat\r\n"
			+ "from schedules\r\n"
			+ "INNER JOIN routes on schedules.route_id = routes.id\r\n"
			+ "INNER JOIN airports as origen ON origen.id = routes.departure_airports_id\r\n"
			+ "INNER JOIN airports as destino ON destino.id = routes.arrival_airports_id\r\n"
			+ "INNER JOIN aircrafts on aircrafts.id =  schedules.aircraft_id \r\n"
			+ "where \r\n"
			+ "( :origen IS NULL OR routes.departure_airports_id like CONCAT('%', :origen, '%'))  and\r\n"
			+ "(:destino IS NULL OR routes.arrival_airports_id like CONCAT('%', :destino, '%'))  and\r\n"
			+ "(:salida IS NULL OR schedules.date >= :salida) AND\r\n"
			+ "( schedules.date <= COALESCE(:llegada, :salida))\r\n"
			+ ";", nativeQuery = true)
	List<FlightDto> getflightfilterOptional(
			@Param("origen") String origen,
			@Param("destino") String destino,
			@Param("salida") LocalDate salida,
			@Param("llegada") LocalDate llegada);
}
