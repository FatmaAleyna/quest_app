package com.project.questapp.responses;

import com.project.questapp.entities.Like;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeResponse {


    Long id;

    Long userId;

    Long postId;

    public LikeResponse(Like entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.postId = entity.getPost().getId();
    }
}
