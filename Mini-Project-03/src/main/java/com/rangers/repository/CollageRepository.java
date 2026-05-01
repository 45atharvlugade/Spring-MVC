package com.rangers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rangers.entity.Collage;

public interface CollageRepository extends JpaRepository<Collage, Integer> {

	public Optional<Collage> findByEmail(String email);
}
