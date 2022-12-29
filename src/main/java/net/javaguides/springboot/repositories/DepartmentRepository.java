package net.javaguides.springboot.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entities.Department;

@Transactional
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
