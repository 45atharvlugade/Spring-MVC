package com.al.rangers.service;

import org.springframework.stereotype.Service;

import com.al.rangers.model.Animal;
import com.al.rangers.model.Bird;

@Service
public class ZooService implements ZooManagementSystem {

	@Override
	public String registerSomeOne(Bird bird) {
		
		return bird.toString();
	}

	@Override
	public String registerSomeOne(Animal animal) {
		// TODO Auto-generated method stub
		return animal.toString();
	}

}
