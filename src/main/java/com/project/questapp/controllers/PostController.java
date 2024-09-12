package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService=postService;
	}
	
	@GetMapping
	public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
		 return postService.getAllPosts(userId);
	}
	
	@GetMapping("/{postId}")
	public Optional<Post> getOnepPost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
		return postService.createOnePost(newPostRequest);
	}
}
