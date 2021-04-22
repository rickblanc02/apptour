package com.example.apptour.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.apptour.models.Product;
import com.example.apptour.services.ProductCVS;
import com.example.apptour.services.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")

public class ProductController  {
	@Autowired
	ProductService productService;
			
	@GetMapping("/products")
	public ArrayList<Product> getProducts(){
		
		return productService.getProducts();
				
	}
		
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		
		return this.productService.saveProduct(product);
		
		
	}
	
	//Paginate
	@GetMapping("/products/p")		
	 public ResponseEntity<Map<String, Object>> getProducts(
	
			  
		      @RequestParam(defaultValue = "0") int page,//){//,
		      @RequestParam(defaultValue = "3") int size,	
		      @RequestParam(defaultValue = "id") String sort){
		
		
		  Map<String, Object> response = new HashMap<>();
		  response =  productService.getProducts(page, size, sort);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
				
	}
	
	@PostMapping("/products/u")
	  public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("files") MultipartFile file) {
	    String message = "";
	    Map<String, Object> response = new HashMap<>();
	    
	    if (ProductCVS.hasCSVFormat(file)) {
	      try {
	    	  productService.saveCVS(file);
	    	 
	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        response.put("message", message);
 	       
	    	
	    	  return new ResponseEntity<>(response, HttpStatus.OK);
	       
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        response.put("message", message);
	        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
	       
	      }
	    }

	    message = "Please upload a csv file!";
	    response.put("message", message);
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    
	  }

}
