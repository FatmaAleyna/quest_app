package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.responses.PostResponse;
import com.project.questapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;



@RestController
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService=postService;
	}
	
	@GetMapping
	public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId){
		 return postService.getAllPosts(userId);
	}
	
	@GetMapping("/{postId}")
	public Optional<Post> getOnepPost(@PathVariable Long postId) {
		return Optional.ofNullable(postService.getOnePostById(postId));
	}

	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
		return postService.createOnePost(newPostRequest);
	}

	@PutMapping("/{postId}")
		public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest newPostRequest ) {
		return postService.updateOnePostById(postId,newPostRequest);
	}

	@DeleteMapping("/{postId}")
	public void deleteOnePost(@PathVariable Long postId) {
		postService.deleteOnePostById(postId);
	}

}
