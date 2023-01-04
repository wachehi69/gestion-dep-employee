package net.javaguides.springboot.repositories;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entities.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// @Query("select e from Employee e where e.employeeLastName like :X order by
	// e.employeeLastName asc")
	@Query("select e from Employee e where e.employeeFirstName like :X")
	public Page<Employee> listeEmployeParNom(@Param("X") String employeeLastName, Pageable pageable);

	public Page<Employee> findAllByEmployeeLastName(String employeeLastName, Pageable pageable);

}
