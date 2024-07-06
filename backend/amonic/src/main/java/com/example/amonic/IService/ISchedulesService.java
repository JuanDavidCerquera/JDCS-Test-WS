package com.example.amonic.IService;

import java.time.LocalDate;
import java.util.List;

import com.example.amonic.Entity.Schedules;

public interface ISchedulesService extends IBaseService<Schedules> {

    List<Schedules> getByFilter(
            Long aircraftId,
            Long routeId,
            LocalDate date,
            String time,
            Double economyPrice,
            Boolean confirmed,
            Integer flightNumber);

}
