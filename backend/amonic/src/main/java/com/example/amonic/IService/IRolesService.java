package com.example.amonic.IService;

import java.util.List;

import com.example.amonic.Entity.Roles;

public interface IRolesService extends IBaseService<Roles> {

    List<Roles> getByFilter(Roles filters);
}
