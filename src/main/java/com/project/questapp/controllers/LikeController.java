package com.project.questapp.controllers;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Like;
import com.project.questapp.requests.LikeCreateRequest;
import com.project.questapp.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return likeService.getAllLikesWithParam(userId, postId);
    }

    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId) {
     return likeService.getOneLikeById(likeId);
    }

    @PostMapping
    public Like createOneLike(LikeCreateRequest request){
        return likeService.createOneLike(request);
    }

    @DeleteMapping
    public void deleteOneLike(@PathVariable Long likeId) {
        likeService.deleteOneLike(likeId);
    }
}