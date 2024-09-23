package com.project.questapp.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeCreateRequest {

    private Long Id;

    private Long userId;

    private Long postId;
}
