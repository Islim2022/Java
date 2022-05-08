package com.HaneiIslim.HelloHuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	@RequestMapping("/")
	public String hellohuman(@RequestParam(value="name", required=false) String name,
	@RequestParam(value="last_name", required=false) String last_name) {
		if((name) == null) {
			return "Hello Human";
		} 
		if(last_name == null) {
			return "Hello " + name;
		}
		else {
		return "Hello " + name + " " + last_name;
	    }
	}
}


