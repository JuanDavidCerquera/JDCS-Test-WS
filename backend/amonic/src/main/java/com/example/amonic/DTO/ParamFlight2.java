package com.example.amonic.DTO;

import java.time.LocalDate;

public class ParamFlight2 {

	private String origen;
	private String destino;
	private LocalDate salida;
	private LocalDate llegada;
	private String tipo_cabina;

	public String getTipo_cabina() {
		return tipo_cabina;
	}

	public void setTipo_cabina(String tipo_cabina) {
		this.tipo_cabina = tipo_cabina;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDate getSalida() {
		return salida;
	}

	public void setSalida(LocalDate salida) {
		this.salida = salida;
	}

	public LocalDate getLlegada() {
		return llegada;
	}

	public void setLlegada(LocalDate llegada) {
		this.llegada = llegada;
	}


}
