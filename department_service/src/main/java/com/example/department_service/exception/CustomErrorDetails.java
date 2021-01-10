package com.example.department_service.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorDetails {

	private Date timestamp;
	private String message;
	private String errorDetails;
}
