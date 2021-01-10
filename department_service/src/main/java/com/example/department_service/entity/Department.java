package com.example.department_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private Long departmentId;

	@Column(name = "department_name	")
	@NotEmpty(message = "Department Name is Mandatory field")
	private String departmentName;

	@Column(name = "department_address")
	@NotEmpty(message = "Department Address is Mandatory field")
	private String departmentAddress;

	@Column(name = "department_code")
	@NotEmpty(message = "Department Code is Mandatory field")
	private String departmentCode;

}
