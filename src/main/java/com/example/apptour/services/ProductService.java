package com.example.apptour.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.apptour.models.Product;
//import com.example.apptour.repositories.ProductPageSortRepository;
import com.example.apptour.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository; 
	
	public ArrayList<Product> getProducts(){
		ArrayList<Product> products;
		
		products = (ArrayList<Product>) productRepository.findAll(); 
				
		return products;
	}
	
	public Product saveProduct(Product product) {
		
		product = productRepository.save(product);
		
		return product;
				
	}
	
	//Paginate y sorting
	 public Map<String, Object> getProducts(Integer pageNo, Integer pageSize, String sortBy)
	    {
	        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy)); //ascending DESCENDING 
	 
	        
	        Page<Product> pagedResult = productRepository.findAll(paging);
	        
	        Map<String, Object> data = new HashMap<>();
	       
	         
	        if(pagedResult.hasContent()) {
	        	 data.put("products", pagedResult.getContent());
	 	        data.put("currentPage", pagedResult.getNumber());
	 	        data.put("totalItems", pagedResult.getTotalElements());
	 	        data.put("totalPages", pagedResult.getTotalPages());
	 	      
	 	      return data;
	            
	        } else {
	            	        	
	        	return data;
	        }
	    }
	 
	 public void saveCVS(MultipartFile file) {
		    try {
		      List<Product> productos = ProductCVS.csvToTutorials(file.getInputStream());
		      productRepository.saveAll(productos);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }
		  }

}
