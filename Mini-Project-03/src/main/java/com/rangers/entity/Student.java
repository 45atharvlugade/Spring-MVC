package com.rangers.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="jpa_student")
@Getter
@Setter
@RequiredArgsConstructor
public class Student {

	@Id
	@SequenceGenerator(name="seq1",sequenceName = "student_sequence",initialValue = 10000,allocationSize = 3)
	@GeneratedValue(generator = "seq1",strategy = GenerationType.SEQUENCE)
	private Integer studentId;
	
	@NonNull
	@Column(length = 40)
	private String name;
	
	@NonNull
	@Column(length = 40)
	private String address;
	
	@NonNull
	@Column(length = 40)
	private String createdBy;
	
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@Version
	private Integer updatedCount;
	
	@ManyToOne()
	@JoinColumn(name = "collage_id")
	private Collage collage;
	
	public Student() {
		System.out.println("Student.Student()");
	}
}
