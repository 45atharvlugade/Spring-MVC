package com.rangers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rangers.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
