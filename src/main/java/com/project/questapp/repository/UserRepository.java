package com.project.questapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.questapp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	
}
