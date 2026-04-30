package com.rangers.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rangers.entity.Collage;
import com.rangers.entity.Student;
import com.rangers.repository.CollageRepository;
import com.rangers.repository.StudentRepository;

@Service
public class CollageManagementServie implements ICollageManagementServie {

	@Autowired
	private CollageRepository collageRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public String registerCollage(Collage collage) {
	    Integer collageId=collageRepo.save(collage).getCollageId(); 
		return "Collage Registered Succefully with Collage Id :"+collageId;
	}

	@Override
	public List<Student> recordAllStudent(int collageId,int pageNumber) {
		
		Optional<Collage> collage=collageRepo.findById(collageId);
		
		if(collage.isPresent()) {
			Collage clg=collage.get();
			
			Student student=new Student();
			student.setCollage(clg);
			
			Example<Student> example=Example.of(student);
			
			Pageable pageable=PageRequest.of(pageNumber,10);
			
			Page<Student> page= studentRepo.findAll(example, pageable);
			
			return page.getContent();
		}else {
			return null;
		}
		
		
	}

}
