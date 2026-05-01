package com.al.rangers.service;

import java.util.List;

import com.al.rangers.entity.Actor;

public interface IActorService {

	public List<Actor> getAllActors();
	
	public String registerActor(Actor actor);
	
	public String deleteActorById(int id);
	
}
