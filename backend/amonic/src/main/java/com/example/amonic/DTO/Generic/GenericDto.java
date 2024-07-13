package com.example.amonic.DTO.Generic;

import java.util.List;

public class GenericDto {

	/*Campos que vamos a traer (SELECT)*/
	private List<String> campos; 
	//entidad en la que vamos a hacer la consulta (from)
	private String entidad;
	/*campos que vamos a usar para realisar foreign keys */
	private List<GenericForeignKey> foreignKeys; 
	/*campos que vamos a usar para el where*/
	private List<GenericWhere> wheres;
	
	
	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	public List<String> getCampos() {
		return campos;
	}
	public void setCampos(List<String> campos) {
		this.campos = campos;
	}
	public List<GenericForeignKey> getForeignKeys() {
		return foreignKeys;
	}
	public void setForeignKeys(List<GenericForeignKey> foreignKeys) {
		this.foreignKeys = foreignKeys;
	}
	public List<GenericWhere> getWheres() {
		return wheres;
	}
	public void setWheres(List<GenericWhere> wheres) {
		this.wheres = wheres;
	} 
	
	
	
}
