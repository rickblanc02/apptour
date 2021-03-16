package com.example.apptour.repositories;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.apptour.models.Employee;


@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Long>{
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
