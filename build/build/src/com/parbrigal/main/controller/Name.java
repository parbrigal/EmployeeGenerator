package com.parbrigal.main.controller;

public class Name {
	
	private int id;
	private String name;
	private String gender;
	private String eeStatus;
	
	public Name(int id, String name,String eeStatus, String gender) {

		this.id = id;
		this.name = name;
		this.eeStatus = eeStatus;
		this.gender = gender;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEeStatus() {
		return eeStatus;
	}

	public void setEeStatus(String eeStatus) {
		this.eeStatus = eeStatus;
	}
	
	

}
