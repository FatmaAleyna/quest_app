package com.project.questapp.requests;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class PostCreateRequest {

	Long id;
	
	String text;
	
	String title;
	
	Long userId;

    public void setId(Long id) {
		this.id = id;
	}

    public void setText(String text) {
		this.text = text;
	}

    public void setTitle(String title) {
		this.title = title;
	}

    public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
}
