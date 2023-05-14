package com.lara.resort.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adminId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "sex")
	private String sex;
	
	@Column (name= "admin_name")
	private String adminName;

	public Admin(long adminId, String firstName, String lastName, int age, String sex, String adminName, String city) {
		super();
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
		this.city = city;
		this.adminName = adminName;
	}

	public long getadminId() {
		return adminId;
	}

	public void setUserId(long userId) {
		this.adminId = adminId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Admin ["
						+ "adminId=" + adminId 
						+ ", firstName=" + firstName 
						+ ", lastName=" + lastName 
						+ ", age=" + age
						+ ", sex=" + sex 
						+ ", city=" + city
						+ ", adminName=" + adminName 
				+ "]";
	}

	
	
	/*
	 		{
	 		"firstName":"Lara",
			"lastName":"D",
			"age":45,
			"sex":"M",
			"city":"Bangalore",
			"adminName":"Lara"
 }
	 */
	
}
