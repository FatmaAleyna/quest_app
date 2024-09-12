package com.project.questapp.dtos;

import com.project.questapp.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String userName;

    private String password;

    public User toEntity(){
        User user = new User();
        user.setUserName(this.userName);
        user.setPassword(this.password);
        return user;
    }
}


