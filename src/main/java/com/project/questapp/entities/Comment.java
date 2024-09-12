package com.project.questapp.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // bir kullanıcı silindiğinde onun tüm postları silinmeli
	@JsonIgnore
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // bir kullanıcı silindiğinde onun tüm postları silinmeli
	@JsonIgnore
    private Post post;
    
	@Lob
	@Column(columnDefinition = "text")
	private String text;
}
