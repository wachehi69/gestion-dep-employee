package net.javaguides.springboot.services;

import java.util.List;

import net.javaguides.springboot.entities.Department;

public interface DepartmentService {

	public void createDepartment(Department d);

	public List<Department> findDepartments();

	public Department getOneDepartment(Long id);

}
