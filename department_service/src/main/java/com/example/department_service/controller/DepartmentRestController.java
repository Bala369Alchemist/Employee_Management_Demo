package com.example.department_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.department_service.entity.Department;
import com.example.department_service.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/departments")
@Slf4j
public class DepartmentRestController {

	@Autowired
	private DepartmentService deptServ;
	
	@GetMapping(value = "/")
	public List<Department> getAllDepartment(){
		log.info("from getAllDepartment method of DepartmentRestController");
		return deptServ.getAllDepartment();
	}
	
	@GetMapping(value = "/{departmentId}")
	public Department findByDepartmentId(@PathVariable Long departmentId) {
		log.info("from findByDepartmentId method of DepartmentRestController");
		return deptServ.findByDepartmentId(departmentId);
	}
	
	@PostMapping(value = "/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("from saveDepartment method of DepartmentRestController");
		return deptServ.saveDepartment(department);
	}
	
	@PutMapping(value = "/{departmentId}")
	public Department updateDepartment(@PathVariable Long departmentId , @RequestBody Department department) {
		log.info("from updateDepartment method of DepartmentRestController");
		return deptServ.updateDepartment(departmentId, department);
	}
	
	@DeleteMapping(value = "/{departmentId}")
	public void deleteDepartment(@PathVariable Long departmentId) {
		log.info("from deleteDepartment method of DepartmentRestController");
		deptServ.deleteDepartment(departmentId);
	}
	
	@DeleteMapping(value = "/")
	public void deleteAllDepartment() {
		log.info("from deleteAllDepartment method of DepartmentRestController");
		deptServ.deleteAllDepartment();
	}
}
