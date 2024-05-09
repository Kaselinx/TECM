package com.taishinlife.tecm.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/helo")
public class HelloWorldController {


	@GetMapping("/Index")
	public String HelloTeam() {

		return "Welcome to Tester!";
	}
	

}
