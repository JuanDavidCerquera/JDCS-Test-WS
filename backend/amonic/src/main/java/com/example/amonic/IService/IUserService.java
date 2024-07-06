package com.example.amonic.IService;

import java.util.List;

import com.example.amonic.Entity.User;

public interface IUserService extends IBaseService<User> {

    List<User> getByFilter(
            String email,
            String password,
            String firstName,
            String lastName,
            String birthdate,
            String state,
            Long roleId,
            Long officeId);
}
