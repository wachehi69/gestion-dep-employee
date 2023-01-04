package net.javaguides.springboot.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entities.Department;
import net.javaguides.springboot.entities.Employee;
import net.javaguides.springboot.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void createEmploye(Employee e) {
		Employee emp = new Employee();
		Department dep = new Department();
		dep.setId(e.getDepartmentId());

		emp.setEmployeeFirstName(e.getEmployeeFirstName());
		emp.setEmployeeLastName(e.getEmployeeLastName());
		emp.setEmployeePhone(e.getEmployeePhone());
		emp.setDepartment(dep);

		employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getEmployes() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getOneEmployee(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Map<String, Object> findAllEmployees(int page, int size) {

		try {
			List<Employee> employeeList = new ArrayList<>();
			Pageable paging = PageRequest.of(page, size); // page = numero de page et size = taille de page
			Page<Employee> pageEmploye = this.employeeRepository.findAll(paging);
			employeeList = pageEmploye.getContent(); // pour récuperer la liste des employes par page

			Map<String, Object> employees = new HashMap<>();

			employees.put("employees", employeeList); // la liste de employes par page
			employees.put("pageCurrent", pageEmploye.getNumber()); // la page courante
			employees.put("totalItems", pageEmploye.getTotalElements()); // nmbre total des élements
			employees.put("totalPage", pageEmploye.getTotalPages()); // le nombre total de page

			return employees;

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee e, Long id) {
		Employee emp = this.getOneEmployee(id);
		Department dep = new Department();
		emp.setEmployeeFirstName(e.getEmployeeFirstName());
		emp.setEmployeeLastName(e.getEmployeeLastName());
		emp.setEmployeePhone(e.getEmployeePhone());
		dep.setId(e.getDepartmentId());
		emp.setDepartment(dep);

		return employeeRepository.saveAndFlush(emp);
	}

	@Override
	public Map<String, Object> findEmployees(String employeeLastName, int page, int size) {

		List<Employee> employeeList = new ArrayList<>();
		Map<String, Object> employee = new HashMap<>();

		Pageable paging = PageRequest.of(page, size, Sort.by("employeeFirstName"));
		Page<Employee> pageEmploye = employeeRepository.findAllByEmployeeLastName(employeeLastName, paging);

		if (pageEmploye == null || pageEmploye.isEmpty()) {
			throw new RuntimeException("le nom est inexistant");

		} else {
			employeeList = pageEmploye.getContent();
			employee.put("employee", employeeList);
			employee.put("pageCurrent", pageEmploye.getNumber()); // page courante
			employee.put("totalItems", pageEmploye.getTotalElements()); // nbre d'elments
			employee.put("totalPage", pageEmploye.getTotalPages()); // nbre de pages
		}

		return employee;

	}

	@Override
	public Map<String, Object> findEmployeesByMotCle(String employeeLastName, int page, int size) {

		List<Employee> employeeList = new ArrayList<>();
		Map<String, Object> employee = new HashMap<>();

		Pageable paging = PageRequest.of(page, size);
		Page<Employee> pageEmployee = employeeRepository.listeEmployeParNom("%" + employeeLastName + "%", paging);

		employeeList = pageEmployee.getContent();
		employee.put("employees", employeeList);
		employee.put("pageCurrent", pageEmployee.getNumber());
		employee.put("totalItem", pageEmployee.getTotalElements());
		employee.put("totalPage", pageEmployee.getTotalPages());

		return employee;
	}

}
