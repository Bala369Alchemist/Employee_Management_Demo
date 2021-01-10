package com.example.user_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "first_name")
	@NotEmpty
	private String firstName;
	
	@Column(name = "last_name")
	@NotEmpty
	private String lastName;
	
	@Column(name = "email" , unique = true)
	@NotEmpty
	@Email
	private String email;
	
	@Column(name = "department_id")
	@NotEmpty
	private Long departmentId;
	
	
}
