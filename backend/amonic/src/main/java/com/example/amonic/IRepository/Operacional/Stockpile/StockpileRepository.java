package com.example.amonic.IRepository.Operacional.Stockpile;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;




@Repository
public class StockpileRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public List<Map<String, Object>> findCustomData() {
		 String sql = "SELECT * \r\n"
		 		+ "FROM getflights\r\n"
		 		+ ";";
	        return jdbcTemplate.queryForList(sql);
	        
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
}
