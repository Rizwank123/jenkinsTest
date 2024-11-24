package com.jenkins.org.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private String village;
	private String street;
	private String city;
	private String state;
	private String pinCode;
	private String Country;
}