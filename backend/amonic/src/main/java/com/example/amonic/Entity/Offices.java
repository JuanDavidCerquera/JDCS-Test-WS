package com.example.amonic.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "offices")
public class Offices extends ABaseEntity{

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "phone", nullable = false)
    private Long phone;

    @Column(name = "contact", nullable = false)
    private String contact;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "countries_id", nullable = false)
    private Countries country;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Countries getCountry() {
		return country;
	}

	public void setCountry(Countries country) {
		this.country = country;
	}

	  


}
