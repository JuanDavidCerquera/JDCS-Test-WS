package com.example.amonic.IRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.amonic.Entity.Roles;

@Repository
public interface IRolesRepository extends IBaseRepository<Roles, Long>{


    @Query(value = "SELECT * FROM roles WHERE (:title IS NULL OR title LIKE %:title%)", nativeQuery = true)
    List<Roles> getByFilter(@Param("title") String title);
}
