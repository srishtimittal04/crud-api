package com.springboot.example.crudapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {
	
	@Id
	@Column (name = "ID", nullable = false)
	@GeneratedValue
	private Long id;
	
    @Column(nullable=false)
	private String firstname;
	
    @Column(nullable=false)
	private String lastname;
	
    @Column(nullable=false)
	private String email;
	
    @Column(nullable=false)
	private Integer age;
	
    @Column(nullable=false)
	private String gender;
	
    @Column(nullable=false)
	private String address;
    
    public Employee() {}

	public Employee(Long id, String firstname, String lastname, String email, Integer age, String gender,
			String address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
