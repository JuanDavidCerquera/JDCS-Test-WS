package com.example.amonic.IRepository.Operacional.AirLine;

import org.springframework.stereotype.Repository;

import com.example.amonic.Entity.Operacional.Tickets;
import com.example.amonic.IRepository.Base.IBaseRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ITicketsRepository extends IBaseRepository<Tickets, Long> {
	@Query(value = "SELECT * FROM tickets " +
	        "WHERE (:cabinTypeId IS NULL OR cabin_types_id = :cabinTypeId OR :cabinTypeId = 0) " +
	        "AND (:scheduleId IS NULL OR schedule_id = :scheduleId OR :scheduleId = 0) " +
	        "AND (:userId IS NULL OR user_id = :userId OR :userId = 0) " +
	        "AND (:distance IS NULL OR distance = :distance OR :distance = 0) " +
	        "AND (:firstName IS NULL OR first_name LIKE %:firstName%) " +
	        "AND (:lastName IS NULL OR last_name LIKE %:lastName%) " +
	        "AND (:email IS NULL OR email LIKE %:email%) " +
	        "AND (:phone IS NULL OR phone = :phone OR :phone = 0) " +
	        "AND (:passportNumber IS NULL OR passport_number = :passportNumber OR :passportNumber = 0) " +
	        "AND (:passportCountryId IS NULL OR passport_country_id = :passportCountryId OR :passportCountryId = 0) " +
	        "AND (:passportPhoto IS NULL OR passport_photo = :passportPhoto OR :passportPhoto = 0) " +
	        "AND (:bookingReference IS NULL OR booking_reference = :bookingReference OR :bookingReference = 0) " +
	        "AND (:confirmed IS NULL OR confirmed = :confirmed)", nativeQuery = true)
	List<Tickets> getByFilter(
	        @Param("cabinTypeId") Long cabinTypeId,
	        @Param("scheduleId") Long scheduleId,
	        @Param("userId") Long userId,
	        @Param("distance") Double distance,
	        @Param("firstName") String firstName,
	        @Param("lastName") String lastName,
	        @Param("email") String email,
	        @Param("phone") Long phone,
	        @Param("passportNumber") Long passportNumber,
	        @Param("passportCountryId") Long passportCountryId,
	        @Param("passportPhoto") Long passportPhoto,
	        @Param("bookingReference") Long bookingReference,
	        @Param("confirmed") Boolean confirmed);

}
