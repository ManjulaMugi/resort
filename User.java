package com.lara.resort.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "user_name")
	private String userName;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(long userId, String firstName, String lastName, int age, String sex, String city, String userName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
		this.city = city;
		this.userName = userName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

//	@Test
//	public void test()
//	{
//		System.out.println("i am in testing method");
//	}
	@Override
	public String toString() {
		return "User [userId=" + userId 
				+ ", firstName=" + firstName 
				+ ", lastName=" + lastName 
				+ ", age=" + age
				+ ", sex=" + sex 
				+ ", city=" + city 
				+ ", userName=" + userName 
				+ "]";
	}
	
	
}
/*
 {
 	"firstName":"Manjula",
		"lastName":"M",
		"age":23,
		"sex":"F",
		"city":"Bangalore",
		"userName":"ManjulaMugi"
 }
 */
