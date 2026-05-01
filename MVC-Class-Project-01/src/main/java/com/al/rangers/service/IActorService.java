package com.al.rangers.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.al.rangers.entity.Actor;

public interface IActorService {

	public List<Actor> getAllActors();
	
	public String registerActor(Actor actor);
	
	public String deleteActorById(int id);
	
	public Page<Actor> showAllData(Pageable pabeable);
	
	public Actor editActor(Actor actor);
	
	public Actor findById(int id);
}
