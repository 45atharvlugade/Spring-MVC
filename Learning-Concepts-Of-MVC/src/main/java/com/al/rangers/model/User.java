package com.al.rangers.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User {

	private Integer userId;
	
	private String userName;
	
	private String userAddress="Kolhapur";
	
	private String userEmail;
	
	private Long phoneNumber;
}
