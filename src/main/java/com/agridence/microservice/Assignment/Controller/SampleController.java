package com.agridence.microservice.Assignment.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController	
public class SampleController {
	
	@GetMapping("/index")
		public String index() {
			return "Welcome to spring boot assignment!";
		}

}
