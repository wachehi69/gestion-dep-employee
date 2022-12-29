package net.javaguides.springboot.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entities.Employee;
import net.javaguides.springboot.services.EmployeeService;

@RestController
@RequestMapping(value = "/api")
//@CrossOrigin(value = "*")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public void createEmploye(@RequestBody Employee e) {
		employeeService.createEmploye(e);
	}

	@GetMapping("/employees")
	public List<Employee> getEmployes() {
		return employeeService.getEmployes();
	}

	@GetMapping("/employees/{id}")
	public Employee getOneEmployee(@PathVariable Long id) {
		return employeeService.getOneEmployee(id);
	}

	@GetMapping("/employees/paging")
	public ResponseEntity<Map<String, Object>> findAllPAging(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {
		return new ResponseEntity<>(this.employeeService.findAllEmployees(page, size), HttpStatus.OK);
	}

	@DeleteMapping("/employees/delete/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}

	@PutMapping("/employees/update/{id}")
	public Employee updateEmployee(@RequestBody Employee e, @PathVariable Long id) {
		return employeeService.updateEmployee(e, id);
	}

}
