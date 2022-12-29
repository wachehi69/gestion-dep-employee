package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.entities.Department;
import net.javaguides.springboot.repositories.DepartmentRepository;

@Service
public class DepartementServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	public DepartementServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public void createDepartment(Department d) {
		departmentRepository.save(d);
	}

	@Override
	public List<Department> findDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getOneDepartment(Long id) {
		return departmentRepository.findById(id).get();
	}

}
