package net.javaguides.springboot.services;

import java.util.List;
import java.util.Map;

import net.javaguides.springboot.entities.Employee;

public interface EmployeeService {

	public void createEmploye(Employee e);

	public List<Employee> getEmployes();

	public Employee getOneEmployee(Long id);

	public Map<String, Object> findAllEmployees(int page, int size);

	public void deleteEmployee(Long id);

	public Employee updateEmployee(Employee e, Long id);

	public Map<String, Object> findEmployees(String employeeLastName, int page, int size);

	public Map<String, Object> findEmployeesByMotCle(String employeeLastName, int page, int size);

}
