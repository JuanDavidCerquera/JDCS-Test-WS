package com.example.amonic.DTO.Operacional.AirLine;

import org.springframework.web.multipart.MultipartFile;

public class TicketsImageDto {
	
	private Long cabinType;

	private Long schedule;

	private Long user;

	private Double distance;

	private String firstName;

	private String lastName;

	private String email;

	private Long phone;

	private Long passportNumber;

	private Long passportCountryId;

	private MultipartFile passportPhoto;

	private Long bookingReference;

	private Boolean confirmed;

	public Long getCabinType() {
		return cabinType;
	}

	public void setCabinType(Long cabinType) {
		this.cabinType = cabinType;
	}

	public Long getSchedule() {
		return schedule;
	}

	public void setSchedule(Long schedule) {
		this.schedule = schedule;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(Long passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Long getPassportCountryId() {
		return passportCountryId;
	}

	public void setPassportCountryId(Long passportCountryId) {
		this.passportCountryId = passportCountryId;
	}

	public MultipartFile getPassportPhoto() {
		return passportPhoto;
	}

	public void setPassportPhoto(MultipartFile passportPhoto) {
		this.passportPhoto = passportPhoto;
	}

	public Long getBookingReference() {
		return bookingReference;
	}

	public void setBookingReference(Long bookingReference) {
		this.bookingReference = bookingReference;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}


}
