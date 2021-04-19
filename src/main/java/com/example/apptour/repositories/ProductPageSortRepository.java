package com.example.apptour.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.apptour.models.Product;

@Repository
public interface ProductPageSortRepository extends PagingAndSortingRepository<Product, Long> {
	
	//@Query("select u from Product u where u.count >= ?1 and u.count <=?2")
	List<Product> findAllByPrize(Double prize, Pageable pageable);
	
	

}
