package com.revature.krowdboot.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	public Address() {
		super();
	}

	public Address(int id, @NotNull String streetAddress, String apartment, @NotNull String city, @NotNull String state,
			@NotNull Integer zip) {
		super();
		this.id = id;
		this.streetAddress = streetAddress;
		this.apartment = apartment;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Address(@NotNull String streetAddress, String apartment, @NotNull String city, @NotNull String state,
			@NotNull Integer zip) {
		super();
		this.streetAddress = streetAddress;
		this.apartment = apartment;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	@NotNull
	private String streetAddress;

	@Column
	private String apartment;

	@Column
	@NotNull
	private String city;

	@Column
	@NotNull
	private String state;

	@Column
	@NotNull
	private Integer zip;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetAddress=" + streetAddress + ", apartment=" + apartment + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apartment, city, id, state, streetAddress, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(apartment, other.apartment) && Objects.equals(city, other.city) && id == other.id
				&& Objects.equals(state, other.state) && Objects.equals(streetAddress, other.streetAddress)
				&& zip == other.zip;
	}

}
