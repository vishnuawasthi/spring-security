package com.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORY_USER")
@SequenceGenerator(name = "SEQ_INVENTORY_USER", initialValue = 001, allocationSize = 1, sequenceName = "SEQ_INVENTORY_USER")
public class User implements Serializable {

	/**
	 * (
	 */
	private static final long serialVersionUID = -7521690083262229937L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INVENTORY_USER")
	@Column(name = "USER_SEQ_NBR", unique = true, updatable = false)
	private Long userSeqNumber;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "username", unique = true, updatable = false, length = 32)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "ADDRESSLINE1")
	private String addressLine1;

	@Column(name = "ADDRESSLINE2")
	private String addressLine2;

	@Column(name = "CITY")
	private String city;

	@Column(name = "PINCODE")
	private String pincode;

	@Column(name = "STATE")
	private String state;

	@Column(name = "COUNTRY")
	private String country;

	public User() {
		super();
	}

	public Long getUserSeqNumber() {
		return userSeqNumber;
	}

	public void setUserSeqNumber(Long userSeqNumber) {
		this.userSeqNumber = userSeqNumber;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
