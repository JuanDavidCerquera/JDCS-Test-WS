package com.example.amonic.DTO.Operacional.Stockpile;

import java.time.LocalDate;

public interface IStockpileDto {
	
	public Long getId();
	public String getOrigen();
	public String getDestino();
	public LocalDate getFecha();
	public String getHora();
	public Long getNumerovuelo();
	public String getTipocabina();
	public Long getPreciocabina();
	public Integer getTotalseats();
	public Integer getAsientosOcupados();
	public Integer getSeatdis();

}
