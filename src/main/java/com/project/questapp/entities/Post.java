package com.project.questapp.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;


@Setter
@Getter
@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // bir kullanıcı silindiğinde onun tüm postları silinmeli
    private User user;
   
	private String title;
    
	@Lob
	@Column(columnDefinition = "text")
	private String text;


}
