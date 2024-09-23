package com.project.questapp.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateRequest {

    Long id;

    Long userId;

    Long postId;

    String text;
}
