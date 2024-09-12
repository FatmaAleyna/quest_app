package com.project.questapp.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="p_like")
@Data
public class Like {

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
}
