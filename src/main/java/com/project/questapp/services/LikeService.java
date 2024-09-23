package com.project.questapp.services;

import com.project.questapp.entities.Like;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repository.LikeRepository;
import com.project.questapp.requests.LikeCreateRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final UserService userService;
    private final PostService postService;

    public LikeService(LikeRepository likeRepository, @Lazy UserService userService, @Lazy PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
        List<Like> list;
        if (userId.isPresent() && postId.isPresent()) {
            list=likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }else if(userId.isPresent()){
            list=likeRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            list=likeRepository.findByPostId(postId.get());
        }
           return list=likeRepository.findAll();
    }

    public Like getOneLikeById(Long likeId) {
        return likeRepository.findById(likeId).get();
    }

    public Like createOneLike(LikeCreateRequest request) {
        Optional<User> user= Optional.ofNullable(userService.getOneUserById(request.getUserId()));
        Optional<Post> post= Optional.ofNullable(postService.getOnePostById(request.getPostId()));
         if (user!=null && post!=null){
             Like likeToSave=new Like();
             likeToSave.setId(request.getId());
             likeToSave.setPost(post.get());
             likeToSave.setUser(user.get());
         }
             return null;
    }

    public void deleteOneLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }


}

