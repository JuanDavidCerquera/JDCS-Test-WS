package com.example.amonic.IService.Operacional.AirLine;

import java.time.LocalDate;
import java.util.List;

import com.example.amonic.DTO.Operacional.Stockpile.IStockpileDto;
import com.example.amonic.DTO.Operacional.Stockpile.StockpileFilter;
import com.example.amonic.Entity.Operacional.Schedules;
import com.example.amonic.IService.Base.IBaseService;

public interface ISchedulesService extends IBaseService<Schedules> {

    List<Schedules> getByFilter(
            Long aircraftId,
            Long routeId,
            LocalDate date,
            String time,
            Double economyPrice,
            Boolean confirmed,
            Integer flightNumber);
    
    List<IStockpileDto> getStockpile(StockpileFilter filters);

}
