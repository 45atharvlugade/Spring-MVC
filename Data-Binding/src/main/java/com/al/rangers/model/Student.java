package com.al.rangers.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("student")
public class Student {

	private Integer studentId;
	 
	private String studentName;
	
	private String studentAddress;
	
	private Double percentage;
}
