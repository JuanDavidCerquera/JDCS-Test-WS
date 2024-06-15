package com.example.amonic.IRepository;

import org.springframework.stereotype.Repository;

import com.example.amonic.Entity.User;

@Repository
public interface IUserRepository extends IBaseRepository<User, Long>{

}
