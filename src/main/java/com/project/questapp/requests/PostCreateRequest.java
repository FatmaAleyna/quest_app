package com.project.questapp.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class PostCreateRequest {

	Long id;
	
	String text;
	
	String title;
	
	Long userId;


}
