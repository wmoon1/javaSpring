package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="participant")
public class Participant {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "partId")
	public int partId;
	
	@NotBlank(message = "Name is mandatory")
	@Column(name= "partName")
	public String name;
	    
	@NotBlank(message = "school is mandatory")
	public int grade;
	
	public String dob;
    public int age;
    public String gender;
    public String email;
   
    
    
    public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Participant(int partId, String dob, int age, String gender, String email, String name, int grade) {
		super();
		this.partId = partId;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.name = name;
		this.grade = grade;
	}
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}    
   