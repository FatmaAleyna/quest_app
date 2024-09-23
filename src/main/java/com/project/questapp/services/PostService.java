package com.project.questapp.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.project.questapp.entities.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repository.PostRepository;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.responses.LikeResponse;
import com.project.questapp.responses.PostResponse;

@Service
public class PostService {

	private final PostRepository postRepository;
	private final UserService userService;
	private final LikeService likeService;

	@Autowired
	public PostService(PostRepository postRepository,
					   @Lazy UserService userService,
					  @Lazy LikeService likeService) {
		this.postRepository = postRepository;
		this.userService = userService;
		this.likeService = likeService;
	}

	public List<PostResponse> getAllPosts(Optional<Long> userId) {
		List<Post> list;
		if (userId.isPresent()) {
			list = postRepository.findByUserId(userId.get());
		} else {
			list = postRepository.findAll();
		}
		return list.stream().map(p -> {
			List<Like> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(p.getId()));
			List<LikeResponse> likeResponses = likes.stream()
					.map(like -> new LikeResponse(like)) // Burada Like'dan LikeResponse'a dönüşüm yapılıyor
					.collect(Collectors.toList());

			return new PostResponse(p, likeResponses); // Likes'ları ekliyoruz
		}).collect(Collectors.toList());
	}

	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public PostResponse getOnePostByIdWithLikes(Long postId) {
		Post post = postRepository.findById(postId).orElse(null);
		List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(postId))
				.stream()
				.map(like -> new LikeResponse(like)) // Like'dan LikeResponse'a dönüşüm
				.collect(Collectors.toList());
		return new PostResponse(post, likes);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {
		Optional<User> user = Optional.ofNullable(userService.getOneUserById(newPostRequest.getUserId()));
		if (!user.isPresent()) // Optional kontrolü
			return null;

		Post toSave = new Post();
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user.get());
		toSave.setCreateDate(new Date());
		return postRepository.save(toSave);
	}

	public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if (post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
	}
}
