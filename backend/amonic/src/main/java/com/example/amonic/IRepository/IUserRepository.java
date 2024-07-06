package com.example.amonic.IRepository;

import org.springframework.stereotype.Repository;

import com.example.amonic.Entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface IUserRepository extends IBaseRepository<User, Long> {

	@Query(value = "SELECT * FROM user " +
			"WHERE (:email IS NULL OR email LIKE %:email%) " +
			"AND (:password IS NULL OR password LIKE %:password%) " +
			"AND (:firstName IS NULL OR first_name LIKE %:firstName%) " +
			"AND (:lastName IS NULL OR last_name LIKE %:lastName%) " +
			"AND (:birthdate IS NULL OR birthdate = :birthdate) " +
			"AND (:state IS NULL OR state = :state) " +
			"AND (:roleId IS NULL OR role_id = :roleId OR :roleId = 0) " +
			"AND (:officeId IS NULL OR office_id = :officeId OR :officeId = 0)", nativeQuery = true)
	List<User> getByFilter(
			@Param("email") String email,
			@Param("password") String password,
			@Param("firstName") String firstName,
			@Param("lastName") String lastName,
			@Param("birthdate") String birthdate,
			@Param("state") String state,
			@Param("roleId") Long roleId,
			@Param("officeId") Long officeId);
}
