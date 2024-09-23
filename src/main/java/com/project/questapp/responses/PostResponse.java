package com.project.questapp.responses;

import com.project.questapp.entities.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostResponse {

    Long Id;

    Long userId;

    String userName;

    String title;

    String text;

    List<LikeResponse> postLikes;



    public PostResponse(Post entity, List<LikeResponse> likes) {
        this.Id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.postLikes = likes;
    }


}
