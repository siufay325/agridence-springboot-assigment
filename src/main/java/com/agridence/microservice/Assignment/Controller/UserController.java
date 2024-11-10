package com.agridence.microservice.Assignment.Controller;

import com.agridence.microservice.Assignment.DTO.*;
import com.agridence.microservice.Assignment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public CommonResponse<EmptyResponse> signup(@RequestBody SignupRequest request) {
		return userService.signup(request);
	}

	@PostMapping("/login")
	public CommonResponse<LoginResponse> login(@RequestBody LoginRequest request) {
		return userService.login(request);
	}

}
