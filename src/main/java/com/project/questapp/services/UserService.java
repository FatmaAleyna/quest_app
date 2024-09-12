package com.project.questapp.services;

import java.util.List;
import java.util.Optional;

import dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.questapp.entities.User;
import com.project.questapp.repository.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void saveOneUser(UserDTO userDTO) {
		User newUser = userDTO.toEntity();
		userRepository.save(newUser);
	}

	public Optional<User> getOneUser(Long userId) {
		return userRepository.findById(userId);
	}

//	public User updateOneUser(Long userId, User newUser) {
//	    Optional<User> user=userRepository.findById(userId);
//		
//		if(user.isPresent()) {
//			User foundUser=user.get();
//			foundUser.setUserName(newUser.getUserName());
//			foundUser.setPassword(newUser.getPassword());
//			userRepository.save(foundUser);
//			return foundUser;
//		}
//		else {
//			return null;
//		}
//	}

	public void deleteOneUser(Long userId) {
          userRepository.deleteById(userId);		
	}
	
	
	
}
