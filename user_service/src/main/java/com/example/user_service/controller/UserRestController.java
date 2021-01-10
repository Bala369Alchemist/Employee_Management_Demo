package com.example.user_service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.entity.User;
import com.example.user_service.service.UserService;
import com.example.user_service.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserRestController {

	@Autowired
	private UserService userServ;
	
	// to get all users
	@GetMapping(value = "/")
	public  List<User> getAllUser() {
		log.info("from getAllUser method of UserRestController");
		return userServ.getAllUser();
	}
	
	// to get user based on id
	@GetMapping(value = "/{userId}")
	public User findByUserId(@PathVariable Long userId) {
		log.info("from findByUserId method of UserRestController");
		return userServ.findByUserId(userId);
	}
	
	@GetMapping(value = "/user/{userId}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable Long userId) {
		return userServ.getUserWithDepartment(userId);
	}
	
	// to add new user
	@PostMapping(value = "/")
	public User saveUser(@Valid  @RequestBody User user) {
		log.info("from saveUser method of UserRestController");
		return userServ.saveUser(user);
	}
	
	// to update existing user
	@PutMapping(value = "/{userId}")
	public User updateUser(@PathVariable Long userId,@RequestBody User user) {
		log.info("from updateUser method of UserRestController");
		return userServ.updateUser(userId,user);
	}
	
	// to delete a user
	@DeleteMapping(value = "/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		log.info("from deleteUser method of UserRestController");
		userServ.deleteUser(userId);
	}
	
	
	// to delete all users
	@DeleteMapping(value = "/")
	public void deleteAllUser() {
		log.info("from deleteAllUser method of UserRestController");
		userServ.deleteALlUser();
	}
}
