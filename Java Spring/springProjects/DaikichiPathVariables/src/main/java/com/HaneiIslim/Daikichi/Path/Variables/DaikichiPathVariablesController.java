package com.HaneiIslim.Daikichi.Path.Variables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DaikichiPathVariablesController {

	public static void main(String[] args) {
		SpringApplication.run(DaikichiPathVariablesController.class, args);
	}
	@RequestMapping("/daikichi/{travel}/{city}")
	public String destination(
			@PathVariable("travel") String travel,
			@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city;
		
	}
	
	@RequestMapping("/daikichi/{lotto}/{number}")
	public String message(
			@PathVariable("lotto") String lotto,
			@PathVariable("number") Integer number) {
		if (number %2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		} else {
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
		}
	}
}
