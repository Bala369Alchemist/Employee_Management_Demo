package com.example.department_service.service;

import java.util.List;

import com.example.department_service.entity.Department;

public interface DepartmentService {

	List<Department> getAllDepartment();

	Department findByDepartmentId(Long departmentId);

	Department saveDepartment(Department department);

	Department updateDepartment(Long departmentId, Department department);

	void deleteDepartment(Long departmentId);

	void deleteAllDepartment();

}
