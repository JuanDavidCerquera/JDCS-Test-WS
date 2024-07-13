package com.example.amonic.IService.Operacional.AirLine;

import java.util.List;

import com.example.amonic.Entity.Operacional.Roles;
import com.example.amonic.IService.Base.IBaseService;

public interface IRolesService extends IBaseService<Roles> {

    List<Roles> getByFilter(Roles filters);
}
