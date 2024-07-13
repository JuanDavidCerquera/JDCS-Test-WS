package com.example.amonic.Entity.Operacional;

import com.example.amonic.Entity.Base.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cabinTypes")
public class CabinTypes extends ABaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
