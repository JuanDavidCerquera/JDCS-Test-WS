package com.example.amonic.IRepository.Operacional.AirLine;

import org.springframework.stereotype.Repository;

import com.example.amonic.DTO.Operacional.Stockpile.IStockpileDto;
import com.example.amonic.Entity.Operacional.Schedules;
import com.example.amonic.IRepository.Base.IBaseRepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	@Query(value = ""
			+ "SELECT * \r\n"

			+ "FROM getflights \r\n"
			+ "WHERE \r\n"
			+ "seatdis > coalesce(:seatdis -1, 0) AND \r\n"
			+ "(:id IS NULL OR id = :id or :id = 0) AND \r\n"
			+ "(:origen IS NULL OR origen LIKE %:origen%) AND \r\n"
			+ "(:destino IS NULL OR destino LIKE %:destino%) AND \r\n"
			+ "(:fechaSalida IS NULL OR fecha >= :fechaSalida) AND \r\n"
			+ "(:fechaLlegada IS NULL OR fecha <= :fechaLlegada) AND \r\n"
			+ "(:tipocabina IS NULL OR tipocabina LIKE %:tipocabina%)  \r\n"
			+ "", nativeQuery = true)
	List<IStockpileDto> getStockpile(
			@Param("id") Long id,
			@Param("origen") String Origen,
			@Param("destino") String Destino,
			@Param("fechaSalida") LocalDate fechaSalida,
			@Param("fechaLlegada") LocalDate fechaLlegada,
			@Param("tipocabina") String Tipocabina,
			@Param("seatdis") Integer Seatdis
			);

	
	
	
    /*
-- CREATE view getflights AS

SELECT
schedules.id, 
origen.name AS origen,
destino.name AS destino,
schedules.date AS fecha,
schedules.time AS hora,
schedules.flight_number AS numerovuelo,
ct.name AS tipoCabina,
 CASE
WHEN ct.name = 'economy' THEN schedules.economy_price
WHEN ct.name = 'business' THEN schedules.economy_price * 1.30
END AS preciocabina,
  CASE
WHEN ct.name = 'economy' THEN aircrafts.economy_seats
WHEN ct.name = 'business' THEN aircrafts.business_seats
END AS totalseats,
COUNT(tck.id) AS asientosOcupados,
CASE
WHEN ct.name = 'economy' THEN aircrafts.economy_seats - COUNT(tck.id)
WHEN ct.name = 'business' THEN aircrafts.business_seats - COUNT(tck.id)
END AS seatdis
FROM schedules
INNER JOIN routes ON schedules.route_id = routes.id
INNER JOIN airports AS origen ON origen.id = routes.departure_airports_id
INNER JOIN airports AS destino ON destino.id = routes.arrival_airports_id
INNER JOIN aircrafts ON aircrafts.id = schedules.aircraft_id
CROSS JOIN cabin_types AS ct
left JOIN tickets AS tck ON schedules.id = tck.schedule_id  and tck.cabin_types_id = ct.id
group by schedules.id, ct.id 
ORDER BY schedules.id, ct.id;

*/
}
