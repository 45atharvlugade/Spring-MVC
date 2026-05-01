package com.al.rangers.dto;

import lombok.Data;

@Data
public class ActorEditDto {

	private Integer actorId;
	
	private  String actorName;
	
	private  String address;
	
	private Double fees;
	
	private String category;
}
