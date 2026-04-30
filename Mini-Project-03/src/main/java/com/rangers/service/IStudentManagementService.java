package com.rangers.service;

import com.rangers.entity.Student;

public interface IStudentManagementService {

	public String registerStudent(Student student);
	
	public String deleteStudentRecord(int id);
	
	public String updateStudentDetails(Student student);
}
