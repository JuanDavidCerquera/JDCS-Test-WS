package com.example.amonic.IRepository;

import org.springframework.stereotype.Repository;

import com.example.amonic.Entity.Offices;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface IOfficeRepository extends IBaseRepository<Offices, Long> {

	List<Offices> getbyfilter = null;

	@Query(value = "SELECT * FROM offices " +
			"WHERE (:title IS NULL OR title LIKE %:title%) " +
			"AND (:phone IS NULL OR phone = :phone OR :phone = 0) " +
			"AND (:contact IS NULL OR contact LIKE %:contact%) " +
			"AND (:countryId IS NULL OR countries_id = :countryId OR :countryId = 0)", nativeQuery = true)
	List<Offices> getByFilter(
			@Param("title") String title,
			@Param("phone") Long phone,
			@Param("contact") String contact,
			@Param("countryId") Long countryId);

}
