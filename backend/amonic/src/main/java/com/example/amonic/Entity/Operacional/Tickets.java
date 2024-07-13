package com.example.amonic.Entity.Operacional;



import com.example.amonic.Entity.Base.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Tickets extends ABaseEntity {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cabin_types_id", nullable = false)
	private CabinTypes cabinType;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "schedule_id", nullable = false)
	private Schedules schedule;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "distance", nullable = false)
	private Double distance;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone", nullable = false)
	private Long phone;

	@Column(name = "passport_number", nullable = false)
	private Long passportNumber;

	@Column(name = "passport_country_id", nullable = false)
	private Long passportCountryId;

	@Column(name = "passport_photo", nullable = false, columnDefinition = "LONGTEXT")
	private String passportPhoto;

	@Column(name = "booking_reference", nullable = false)
	private Long bookingReference;

	@Column(name = "confirmed", nullable = false)
	private Boolean confirmed;

	public CabinTypes getCabinType() {
		return cabinType;
	}

	public void setCabinType(CabinTypes cabinType) {
		this.cabinType = cabinType;
	}

	public Schedules getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedules schedule) {
		this.schedule = schedule;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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

	public String getPassportPhoto() {
		return passportPhoto;
	}

	public void setPassportPhoto(String passportPhoto) {
		this.passportPhoto = passportPhoto;
	}



	
}
