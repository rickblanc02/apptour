package com.example.apptour.services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.example.apptour.models.TimePojo;

@Service
public class TimeService {
	
		public TimePojo getTime(TimePojo time)  {
			
			Date now = new Date();
		    
		    
		    //Handle date
		    //Calendar calendar = Calendar.getInstance();
		    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		    //calendar.setTime(now);
		    
		    calendar.getTimeZone().getID();
		    System.out.println(calendar.getTimeZone().getID());
		   
		 
		    //Forma date
		    SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss");
		   
		    try {
				now =dateFormatter.parse(time.getTime());
				
			} catch (ParseException e) {
				time.setTime(e.toString());
				e.printStackTrace();
			}
		    
	        //TimeZone.setDefault( TimeZone.getTimeZone("UTC"));
	        System.out.println(now);
	        
	        
	        //valido que este entre los numeros admitido de UTC
	        if(time.getTimeZoneInt() >= -11 && time.getTimeZoneInt() <= 11) {
	        	
	        	 time.setTimeZone(calendar.getTimeZone().getID());
	        	 calendar.setTime(now);
	        	 calendar.add(Calendar.HOUR,   time.getTimeZoneInt());
	        	 
	        	 //Date now2 = new Date();
	        	 now = calendar.getTime();
	        	 String fechaString = dateFormatter.format(now);
	        	 time.setTime(fechaString);
	        	 System.out.println(time.getTime());
	        }
	        
	       
				
		return time;
		
		
	}

}
