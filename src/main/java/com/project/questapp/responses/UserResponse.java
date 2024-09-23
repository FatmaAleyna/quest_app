package com.project.questapp.responses;

import com.project.questapp.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    Long id;

    int avatarId;

    String userName;

    public UserResponse(User entity) {
        this.id = entity.getId();
        this.avatarId = entity.getAvatar();
        this.userName = entity.getUserName();
    }
}
