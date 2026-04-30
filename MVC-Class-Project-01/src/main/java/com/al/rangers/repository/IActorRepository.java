package com.al.rangers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.al.rangers.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer>{

}
