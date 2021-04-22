package com.example.apptour.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.apptour.models.Product;



@Repository
//public interface EmployeeRepository extends CrudRepository<Employee, Long>{
public interface ProductRepository extends JpaRepository<Product, Long>{


}
