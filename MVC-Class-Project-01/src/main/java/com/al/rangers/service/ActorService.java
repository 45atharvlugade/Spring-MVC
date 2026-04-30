package com.al.rangers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al.rangers.entity.Actor;
import com.al.rangers.repository.IActorRepository;

@Service
public class ActorService implements IActorService {

	@Autowired
	private IActorRepository actorRepo;
	
	@Override
	public List<Actor> getAllActors() {
		
		return actorRepo.findAll();
	}

}
