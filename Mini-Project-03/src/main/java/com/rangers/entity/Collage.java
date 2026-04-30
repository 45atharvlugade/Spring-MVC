package com.rangers.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="collage")
@Getter
@Setter
@RequiredArgsConstructor
public class Collage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer collageId;
	
	@NonNull
	@Column(length=40)
	private String name;
	
	@NonNull
	@Column(length = 20)
	private String email;
	
	@NonNull
	@Column(length = 40)
	private String address;
	
	@NonNull
	private String password;
	
	@CreationTimestamp
	private LocalDate createdOn;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Student> student;

	@Override
	public String toString() {
		return "Collage [collageId=" + collageId + ", name=" + name + ", address=" + address + ", createdOn="
				+ createdOn + "]";
	}
	
	public Collage() {
		System.out.println("Collage.Collage()");
	}
}
