package com.al.rangers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al.rangers.entity.User;
import com.al.rangers.repository.UserRepository;


@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public String registerUser(User user) {
		repository.save(user);
		return "User Registered Succefully";
	}

}
