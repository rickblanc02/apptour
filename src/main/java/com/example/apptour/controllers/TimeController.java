package com.example.apptour.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apptour.models.TimePojo;
import com.example.apptour.services.TimeService;

//https://app-tours.herokuapp.com/ api
//https://venezuelabackpackers.herokuapp.com from
//from react
//https://605cb5a3cfef0f0008041892--sad-nobel-da4ea6.netlify.app/
///@CrossOrigin(origins = "http://localhost:9000")
@CrossOrigin(origins = "https://605cb5a3cfef0f0008041892--sad-nobel-da4ea6.netlify.app")
//@CrossOrigin(origins = "https://venezuelabackpackers.herokuapp.com")
@RestController
@RequestMapping("/api/v1/")
public class TimeController {
	
	@Autowired
	TimeService timeService;
		@PostMapping("/time")
		public TimePojo getTime(@RequestBody TimePojo time) {
			
			//TimePojo time = new TimePojo();
			
			return timeService.getTime(time);
					
		}

}
