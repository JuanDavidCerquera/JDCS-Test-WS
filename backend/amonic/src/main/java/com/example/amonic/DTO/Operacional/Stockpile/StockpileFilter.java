package com.example.amonic.DTO.Operacional.Stockpile;

import java.time.LocalDate;

public class StockpileFilter {

	private Long Id;
	private String Origen;
	private String Destino;
	private LocalDate FechaSalida;
	private LocalDate FechaLlegada;
	private String Tipocabina;
	private Integer Seatdis;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getOrigen() {
		return Origen;
	}
	public void setOrigen(String origen) {
		Origen = origen;
	}
	public String getDestino() {
		return Destino;
	}
	public void setDestino(String destino) {
		Destino = destino;
	}
	public LocalDate getFechaSalida() {
		return FechaSalida;
	}
	public void setFechaSalida(LocalDate fechaSalida) {
		FechaSalida = fechaSalida;
	}
	public LocalDate getFechaLlegada() {
		return FechaLlegada;
	}
	public void setFechaLlegada(LocalDate fechaLlegada) {
		FechaLlegada = fechaLlegada;
	}
	public String getTipocabina() {
		return Tipocabina;
	}
	public void setTipocabina(String tipocabina) {
		Tipocabina = tipocabina;
	}
	public Integer getSeatdis() {
		return Seatdis;
	}
	public void setSeatdis(Integer seatdis) {
		Seatdis = seatdis;
	}
	

	
}
