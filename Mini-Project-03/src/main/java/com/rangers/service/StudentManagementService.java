package com.rangers.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rangers.entity.Student;
import com.rangers.repository.CollageRepository;
import com.rangers.repository.StudentRepository;

@Service
public class StudentManagementService implements IStudentManagementService {
  

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private CollageRepository collageRepo;
	
	@Override
	public String registerStudent(Student student) {
		Integer id=studentRepo.save(student).getStudentId();
		return "Student Saved with student Id : "+id;
	}

	@Override
	public String deleteStudentRecord(int id) {
		Optional<Student> opt=studentRepo.findById(id);
		if(opt.isPresent()) {
			studentRepo.deleteById(id);
			return "Student deleted With Student Id : "+id;
		}else {
			return "No record found with student id : "+id;
		}
	}

	@Override
	public String updateStudentDetails(Student student) {
		Optional<Student> opt=studentRepo.findById(student.getStudentId());
		if(opt.isPresent()) {
			
			studentRepo.save(student);
			return "Student Updated For Student Id : "+student.getStudentId();
		}else {
			return "No record found with student id : "+student.getStudentId();
		}
	}

}
