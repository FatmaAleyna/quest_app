package com.project.questapp.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private Post post;
    
	@Lob
	@Column(columnDefinition = "text")
	private String text;

    @Temporal(TemporalType.TIMESTAMP)
    Date createDate;}
