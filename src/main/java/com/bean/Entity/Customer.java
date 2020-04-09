package com.bean.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer_details")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull(message = "is required ")
	@Size(min = 2, message = "Your first name must be two characters long")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Please enter valid first name")
	// -----------------Database annotations------------------//
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "is required ")
	@Size(min = 2, message = "Your last name must be two characters long")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Please enter valid last name")
	// -----------------Database annotations------------------//
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "Please enter email")
	@Email(message = "Please enter valid email address")
	// -----------------Database annotations------------------//
	@Column(name = "email")
	private String email;

	/*
	 * Default constructor is needed to run hibernate application for Entity class
	 */
	public Customer() {

	}

	/* GETTERS AND SETTERS */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName.toLowerCase();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName.toLowerCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
