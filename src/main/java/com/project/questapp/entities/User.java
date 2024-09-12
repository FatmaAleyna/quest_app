package com.project.questapp.entities;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

	@Id
	@SequenceGenerator(
			name = "user_seq",
			sequenceName = "user_seq",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "user_seq"
	)
	private Long id; 

	private String userName;

	private String password;

}
