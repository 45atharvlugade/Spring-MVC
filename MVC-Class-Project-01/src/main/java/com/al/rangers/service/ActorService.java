package com.al.rangers.service;

import java.util.List;
import java.util.Optional;

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
	
	public String registerActor(Actor actor) {
		int id = actorRepo.save(actor).getActorId();
		return "Actor Registered with actor id of : "+id;
	}

	@Override
	public String deleteActorById(int id) {
		Optional<Actor> opt=actorRepo.findById(id);
		String msg;
		if(opt.isPresent()) {
			Actor actor=opt.get();
			actorRepo.delete(actor);
			msg="Actor which have ActorId "+id+" is deleted";
		}else {
			msg="No Record For this Actor id";
		}
		return msg;
	}

	
	
}
