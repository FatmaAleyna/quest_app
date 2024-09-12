package com.project.questapp.controllers;

import dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.User;
import com.project.questapp.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping
    public List<User> getAllUser(){
      return userService.getAllUsers();
    	
    }
	
	@PostMapping()
	public void createUser(@RequestBody UserDTO userDTO)
	{
		userService.saveOneUser(userDTO);
	}
	
	@GetMapping("/{userId}")
	public Optional<User> getOneUser(@PathVariable Long userId) {
		return  userService.getOneUser(userId);
	}
	
//	@PutMapping("/{userId}")
//	public User updeteOneUser(@PathVariable Long userId, @RequestBody User newUser) {
//	     return userService.updateOneUser(userId,newUser);
//	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
         userService.deleteOneUser(userId);
	}
	
}
