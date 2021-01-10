package com.example.user_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.user_service.entity.User;
import com.example.user_service.vo.ResponseTemplateVO;

public interface UserService {

	List<User> getAllUser();

	User findByUserId(Long userId);

	User saveUser(User user);

	User updateUser(Long userId, User user);

	void deleteUser(Long userId);

	void deleteALlUser();

	ResponseTemplateVO getUserWithDepartment(Long userId);

}
