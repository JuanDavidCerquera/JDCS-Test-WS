package com.example.amonic.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public interface FlightDto {
    Long getId();

    String getOrigen();

    String getDestino();

    LocalDate getFecha();

    LocalTime getHora();

    String getNumerovuelo();

    Double getPreciocabina();

    Integer getEcoseat();

    Integer getBusseat();
}
