package com.example.apptour;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
	
	@RequestMapping("/")
	public String hola() {
		
		return "Hola Mundo";
		
	}

}
