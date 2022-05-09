package com.HaneiIslim.DisplayDate.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Controller;

@Controller
public class DisplayDateController {
	
	@RequestMapping("/") 
	public String Index() {
		return "Index.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
    	DateFormat df = new SimpleDateFormat("hh.mm aa");
    	String date = df.format(new Date()).toString();
    	model.addAttribute("time",date);
      
        return "Time.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");  
		   LocalDateTime date = LocalDateTime.now();  
		   String dateFormat = dtf.format(date);
		   DayOfWeek day=date.getDayOfWeek();
		   model.addAttribute("date",dateFormat);
		   model.addAttribute("day",day);
		
		return "Date.jsp";
	}

}
