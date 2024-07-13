package com.example.amonic.IService.Operacional.AirLine;

import java.util.List;

import com.example.amonic.Entity.Operacional.Tickets;
import com.example.amonic.IService.Base.IBaseService;

public interface ITicketsService extends IBaseService<Tickets> {

    List<Tickets> getByFilter(
            Long cabinTypeId,
            Long scheduleId,
            Long userId,
            Double distance,
            String firstName,
            String lastName,
            String email,
            Long phone,
            Long passportNumber,
            Long passportCountryId,
            Long passportPhoto,
            Long bookingReference,
            Boolean confirmed);
    
    void saveTicketsImage();
}

	
