package com.shadab.model;


public class JobSeeker {
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

 

	private String name;
    private String phoneNumber;
    private String email;
    private String dateOfBirth;
    public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}



	private String location;
  
	public JobSeeker() {
		
	}
    public JobSeeker(String name, String phoneNumber , String email, String dateOfBirth, String location) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
    }
}