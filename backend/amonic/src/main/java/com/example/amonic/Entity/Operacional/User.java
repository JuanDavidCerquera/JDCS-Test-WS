package com.example.amonic.Entity.Operacional;

import com.example.amonic.Entity.Base.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity(name = "user")
public class User extends ABaseEntity {

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "birthdate", nullable = false)
	private String birthdate;

	@Column(name = "state", nullable = false)
	private String state;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "role_id", nullable = false)
	private Roles rolesId;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "office_id", nullable = false)
	private Offices officeId;

	public Roles getRolesId() {
		return rolesId;
	}

	public void setRolesId(Roles rolesId) {
		this.rolesId = rolesId;
	}

	public Offices getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Offices officeId) {
		this.officeId = officeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
