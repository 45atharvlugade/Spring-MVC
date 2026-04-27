package com.al.rangers.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	
	private Integer cno;
	
	private String cname;
	
	private String caddress;
	
	private Double billAmount;
}
