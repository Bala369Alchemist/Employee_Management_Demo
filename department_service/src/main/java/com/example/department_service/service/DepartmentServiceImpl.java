package com.example.department_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.department_service.entity.Department;
import com.example.department_service.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public ResponseEntity<List<Department>> getAllDepartment() {
		log.info("from getAllDepartment method of DepartmentService");
		List<Department> departments = deptRepo.findAll();
		if(departments.isEmpty()) {
			return new ResponseEntity<List<Department>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Department>>(departments,HttpStatus.OK);
	}

	@Override
	public Department findByDepartmentId(Long departmentId) {
		log.info("from findByDepartmentId method of DepartmentService");
		return deptRepo.findByDepartmentId(departmentId);

	}

	@Override
	public Department saveDepartment(Department department) {
		log.info("from saveDepartment method of DepartmentService");
		return deptRepo.save(department);
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		log.info("from updateDepartment method of DepartmentService");
		Department currentDepartment = deptRepo.findByDepartmentId(departmentId);
		currentDepartment.setDepartmentName(department.getDepartmentName());
		currentDepartment.setDepartmentAddress(department.getDepartmentAddress());
		currentDepartment.setDepartmentCode(department.getDepartmentCode());
		return deptRepo.save(currentDepartment);
	}

	@Override
	public void deleteDepartment(Long departmentId) {
		log.info("from deleteDepartment method of DepartmentService");
		deptRepo.deleteById(departmentId);
	}

	@Override
	public void deleteAllDepartment() {
		log.info("from deleteAllDepartment method of DepartmentService");
		deptRepo.deleteAll();
	}
	
}
