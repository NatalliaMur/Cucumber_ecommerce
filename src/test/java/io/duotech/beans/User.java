package io.duotech.beans;

public class User {
	private String firstName;
	private String lastName;
	private String password;
	private String address;
	private String city;
	private String zip;
	private String phone;
	
	//beans, pojo(plain old java object), model >> simple Java class that represents the custom object that I am going
			//to use in my Datatable arguments
	
	public User(String firstName, String lastName, String password, String address, String city, String zip,
			String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	

}
