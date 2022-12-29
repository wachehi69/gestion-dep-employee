package net.javaguides.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entities.Department;
import net.javaguides.springboot.services.DepartmentService;

@RestController
@RequestMapping(value = "/api")
public class DepartmentRestController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/departments")
	public void createDepartment(@RequestBody Department d) {
		departmentService.createDepartment(d);
	}

	@GetMapping("/departments")
	public List<Department> findDepartments() {
		return departmentService.findDepartments();
	}

	@GetMapping("/departments/{id}")
	public Department getOneDepartment(@PathVariable Long id) {
		return departmentService.getOneDepartment(id);
	}

}
