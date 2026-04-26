package com.al.rangers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.al.rangers.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
