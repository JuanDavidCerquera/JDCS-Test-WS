package com.example.amonic.DTO.Operacional.AirLine;

public class UserDto {

	private String email;

	private String password;

	private String firstName;

	private String lastName;

	private String birthdate;

	private String state;

	private Long rolesId;

	private Long officeId;

	public Long getRolesId() {
		return rolesId;
	}

	public void setRolesId(Long rolesId) {
		this.rolesId = rolesId;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
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
