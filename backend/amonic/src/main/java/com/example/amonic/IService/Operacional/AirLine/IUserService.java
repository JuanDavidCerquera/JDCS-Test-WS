package com.example.amonic.IService.Operacional.AirLine;

import java.util.List;

import com.example.amonic.Entity.Operacional.User;
import com.example.amonic.IService.Base.IBaseService;

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
