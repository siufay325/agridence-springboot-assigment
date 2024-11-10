package com.agridence.microservice.Assignment.Service;

import com.agridence.microservice.Assignment.DTO.*;
import com.agridence.microservice.Assignment.Entity.User;
import com.agridence.microservice.Assignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public CommonResponse<EmptyResponse> signup(SignupRequest request) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user != null) {
            return CommonResponse.fail("Username already exists");
        }

        user = new User();
        user.setUsername(request.getUsername());
        user.setEncodedPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());

        userRepository.save(user);

        return CommonResponse.success();
    }

    @Transactional(readOnly = true)
    public CommonResponse<LoginResponse> login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getEncodedPassword())) {
            return CommonResponse.fail("Invalid username/password");
        }

        // mock token
        return CommonResponse.success(new LoginResponse(String.valueOf(user.getId())));
    }

    public Long getUserId(String accessToken) {
        // mock logic
        return Long.valueOf(accessToken);
    }

}
