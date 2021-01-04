package com.example.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user_service.entity.User;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.vo.Department;
import com.example.user_service.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	// to get all users
	@Override
	public List<User> getAllUser() {
		log.info("from getAllUser method of UserService");
		return userRepo.findAll();
	}

	// to find a user by id
	@Override
	public User findByUserId(Long userId) {
		log.info("from findByUserId method of UserService");
		return userRepo.findByUserId(userId);
	}

	// to save a new user
	@Override
	public User saveUser(User user) {
		log.info("from saveUser method of UserService");
		return userRepo.save(user);
	}

	// to update existing user
	@Override
	public User updateUser(Long userId, User user) {
		log.info("from updateUser method of UserService");
		User currentUser = userRepo.findByUserId(userId);
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setEmail(user.getEmail());
		currentUser.setDepartmentId(user.getDepartmentId());
		return userRepo.save(currentUser);
	}

	// to delete a particular user
	@Override
	public void deleteUser(Long userId) {
		log.info("from deleteUser method of UserService");
		userRepo.deleteById(userId);
	}

	@Override
	public void deleteALlUser() {
		log.info("from deleteALlUser method of UserService");
		userRepo.deleteAll();
	}

	@Override
	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepo.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}
