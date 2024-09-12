package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repository.PostRepository;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.services.UserService;


@Service
public class PostService {
	
	private final PostRepository postRepository;
	private final UserService userService;

	@Autowired
	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository=postRepository;
		this.userService=userService;
	}


	public List<Post> getAllPosts( Optional<Long> userId) {
		if(userId.isPresent()) 
			return postRepository.findByUserId(userId.get());
		return postRepository.findAll();
	}


	public Optional<Post> getOnePostById(Long postId) {
		return postRepository.findById(postId);
	}


	public Post createOnePost(PostCreateRequest newPostRequest) {
	    Optional<User> optionalUser = userService.getOneUser(newPostRequest.getUserId());

	    if (optionalUser.isEmpty()) {
	        return null;
	    }

	    User user = optionalUser.get();

	    Post toSave = new Post();
	    toSave.setId(newPostRequest.getUserId());  // ID'yi set etmek doğru.
	    toSave.setText(newPostRequest.getText());
	    toSave.setTitle(newPostRequest.getTitle());
	    toSave.setUser(user);  // Burada User nesnesini set edin.

	    return postRepository.save(toSave);
	}




	

	
	
}