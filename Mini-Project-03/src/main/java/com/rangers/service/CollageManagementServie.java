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

	@Override
	public String updateCollage(Collage collage) {
		Optional<Collage> opt=collageRepo.findById(collage.getCollageId());
		String msg = null;
		if(opt.isPresent()) {
			Collage clg=opt.get();
			if(
					(collage.getEmail()!=null && !collage.getEmail().isEmpty())
					||   
					(collage.getAddress()!=null && !collage.getAddress().isEmpty())
					||
					(collage.getPassword()!=null && !collage.getPassword().isEmpty())	
					||
					(collage.getName()!=null && !collage.getName().isEmpty())
					) {
				
				clg.setEmail(collage.getEmail());
				clg.setAddress(collage.getAddress());
				clg.setName(collage.getName());
				
				collageRepo.save(clg);
				
				msg="Collage Details Updated Successfully";
			}
		}else {
			
			msg="No Collage Found ";
		}
		return msg;
	}

	@Override
	public Collage loginCollage(String email) {


	   
	  Optional<Collage> opt= collageRepo.findByEmail(email);
	  if(opt.isPresent()) {
//		  sb.append("Collage Email Id Found verying the password");
	   return opt.get();	  
	  }
	  else {
		  return null;                  
	  }
	}

}
