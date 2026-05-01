package com.al.rangers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.al.rangers.entity.Actor;
import com.al.rangers.repository.IActorRepository;

import jakarta.transaction.Transactional;

@Service
public class ActorService implements IActorService {

	@Autowired
	private IActorRepository actorRepo;
	
	@Override
	public List<Actor> getAllActors() {
		
		return actorRepo.findAll();
	}
	
	@Transactional
	public String registerActor(Actor actor) {
		int id = actorRepo.save(actor).getActorId();
		return "Actor Registered with actor id of : "+id;
	}

	@Override
	@Transactional
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

	@Override
	public Page<Actor> showAllData(Pageable pageable) {
		
		return actorRepo.findAll(pageable);
	}

	@Override
	public Actor editActor(Actor actor) {
		
		Optional<Actor> opt=actorRepo.findById(actor.getActorId());
		if(opt.isPresent()) {
			Actor actor1=opt.get();
			actorRepo.save(actor);
			return actor1;
		}
		else {
		return null;
		}
	}

	@Override
	public Actor findById(int id) {
		
		Optional<Actor> opt=actorRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			System.out.println("No actor found for id : "+id);
		return null;
		}
	}

	
	
}
