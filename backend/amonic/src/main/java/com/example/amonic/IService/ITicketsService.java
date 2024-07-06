package com.example.amonic.IService;

import java.util.List;

import com.example.amonic.Entity.Tickets;

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
}
