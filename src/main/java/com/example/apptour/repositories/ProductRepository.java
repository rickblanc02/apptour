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
	
	 @Query("select u from Product u where u.count >= ?1 and u.count <=?2")
	 Product findByCountBetween(int count01, int count02);
	 
	 @Query("select u from Product u where u.name like %?1")
	  List<Product> findByNameEndsWith(String name);
	 
	 @Query(value = "SELECT * FROM PRODUCTS WHERE ID = ?1", nativeQuery = true)
	 Product findById(long id);
	 
	 //Paginacion con query native
	 @Query(value = "SELECT * FROM PRODUCTS WHERE NAME = ?1",
			    countQuery = "SELECT count(*) FROM PRODUCTS WHERE NAME = ?1",
			    nativeQuery = true)
     Page<Product> findByLastname(String lastname, Pageable pageable);
	 
	 //Sort
	 @Query("select u from Product u where u.name like ?1%")
	  List<Product> findByAndSort(String lastname, Sort sort);
	 
	 //Param
	 @Query("select u from Product u where u.name = :firstname or u.name = :lastname")
	 Product findByLastnameOrFirstname(@Param("lastname") String lastname,
	                                 @Param("firstname") String firstname);
	

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query

	 
	 

}
