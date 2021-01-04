package com.example.cloud_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackRestController {

	@GetMapping(value = "/userServiceFallBack")
	public String userServiceFallBackMethod() {
		return "User service is taking longer than expected  . Try after sometime";
	}
	
	@GetMapping(value = "/departmentServiceFallBack")
	public String departmentServiceFallBackMethod() {
		return "Department service is taking longer than expected  . Try after sometime";
	}
}
