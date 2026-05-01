package com.rangers.service;

import java.util.List;

import com.rangers.entity.Collage;
import com.rangers.entity.Student;

public interface ICollageManagementServie {

	public String registerCollage(Collage collage);
	
	public List<Student> recordAllStudent(int collageId,int pageNumber);
	
	public String updateCollage(Collage collage);
	
	public Collage loginCollage(String email);
}
