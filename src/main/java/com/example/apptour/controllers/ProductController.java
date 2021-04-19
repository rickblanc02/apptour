package com.example.apptour.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.example.apptour.models.Employee;
import com.example.apptour.models.Product;
import com.example.apptour.models.ResponseMessage;
import com.example.apptour.services.EmployeeService;
import com.example.apptour.services.ProductCVS;
import com.example.apptour.services.ProductService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://607ded16c239870008a5e3f5--goofy-wing-f46d86.netlify.app")
@RestController
@RequestMapping("/api/v1/")

public class ProductController  {
	@Autowired
	ProductService productService;
	
	private static String UPLOADED_FOLDER = "D:\\spring\\video\\";
		
	@GetMapping("/products")
	public ArrayList<Product> getProducts(){
		
		return productService.getProducts();
				
	}
		
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		
		return this.productService.saveProduct(product);
		
		
	}
	
	//Paginado
	@GetMapping("/products/p")		
	 public ResponseEntity<Map<String, Object>> getProducts(
	//public List<Object> getProducts(
			  //@RequestParam(required = false) String title,
		      @RequestParam(defaultValue = "0") int page,//){//,
		      @RequestParam(defaultValue = "3") int size,
		      //@RequestParam(defaultValue = "id,desc") String[] sort){
		      @RequestParam(defaultValue = "id") String sort){
		
		System.out.println("page : "+page);
		  Map<String, Object> response = new HashMap<>();
		  response =  productService.getProducts(page, size, sort);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		//return productService.getProducts(page, size, sort);
				
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

/*
 *
 //Paginado sin total
	@GetMapping("/products/p")
	// public List<Product> getProducts(Integer pageNo, Integer pageSize, String sortBy)
	public List<Product> getProducts(
			  //@RequestParam(required = false) String title,
		      @RequestParam(defaultValue = "0") int page,//){//,
		      @RequestParam(defaultValue = "3") int size,
		      //@RequestParam(defaultValue = "id,desc") String[] sort){
		      @RequestParam(defaultValue = "id") String sort){
		
		System.out.println("page : "+page);
		
		return productService.getProducts(page, size, sort);
				
	}
	
	@PostMapping("/upload") 
	    public String singleFileUpload(@RequestParam("file") MultipartFile file
	                                   ) {
	        if (file.isEmpty()) {
	            
	            return "isEmpty";
	        }

	        try {

	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);
	            

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return "Ok";
	    }
*/
