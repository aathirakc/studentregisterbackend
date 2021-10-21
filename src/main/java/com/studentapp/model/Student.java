package com.studentapp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {

    @Transient
    public static final String SEQUENCE_NAME = "student_sequence";

    @Id
    private String id;

    @NotBlank
    @Size(max = 100)
    private String name;
    

    @NotBlank
    @Size(max = 100)
    private String dateofbirth;
    
    @NotBlank
    @Size(max = 100)
    private String cls;
    
    @NotBlank
    @Size(max = 100)
    private String division;
    
    @NotBlank
    @Size(max = 100)
    private String gender;
    
    

    public Student() {

    }

    public Student(String name,  String dateofbirth, String cls, String division, String gender) {
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.cls = cls;
        this.division = division;
        this.gender = gender;
        
        
    }

   
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
    public String toString() {
        return "Student [id=" + id + ", Name=" + name + ", dateofbirth=" + dateofbirth + ", class=" + cls + ",division=" + division + ", gender=" + gender + 
            "]";
    }
}