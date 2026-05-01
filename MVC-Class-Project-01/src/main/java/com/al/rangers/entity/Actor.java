package com.al.rangers.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="jpa_actor")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer actorId;
	
	@NonNull
	@Column(length = 40)
	private String actorName;
	
	@NonNull
	@Column(length = 40)
	private String address;
	
	@NonNull
	private Double fees;
	
	@NonNull
	@Column(length = 40)
	private String category;
	
	// Meta Data Columns 
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdDate;   // timestamp feature
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime updatedDate;    // timestamp feature
	
	@Version
	private Integer updateCount;  // versioning counter
	
	@Column(length = 30,updatable = false)
	private String createdBy;
	
	@Column(length = 30,insertable = false)
	private String updatedBy;
	
	
	public Actor() {
		System.out.println("Actor.Actor()");
		
	}
}
