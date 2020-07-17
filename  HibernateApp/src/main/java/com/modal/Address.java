package com.modal;

import javax.persistence.Embeddable;

// this is not independent object therefore here I can't put entity(address is associated with some entity like student , Employee)
// these type of object are value objects(they must be associated with something else)
@Embeddable
public class Address {

	private String doorNo;
	private String street;
	private String city;
	
	
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", city=" + city + "]";
	}
	
}
