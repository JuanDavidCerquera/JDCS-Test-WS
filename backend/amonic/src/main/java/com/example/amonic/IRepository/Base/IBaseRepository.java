package com.example.amonic.IRepository.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.amonic.Entity.Base.ABaseEntity;

@Repository
public interface IBaseRepository <T extends ABaseEntity, ID> extends JpaRepository<T, Long> {

}
