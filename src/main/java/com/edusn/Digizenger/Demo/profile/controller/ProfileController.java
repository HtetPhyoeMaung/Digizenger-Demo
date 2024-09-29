package com.edusn.Digizenger.Demo.profile.controller;

import com.edusn.Digizenger.Demo.auth.dto.response.Response;
import com.edusn.Digizenger.Demo.auth.entity.User;
import com.edusn.Digizenger.Demo.auth.repo.UserRepository;
import com.edusn.Digizenger.Demo.exception.UserNotFoundException;
import com.edusn.Digizenger.Demo.profile.dto.response.ProfileDto;
import com.edusn.Digizenger.Demo.profile.service.ProfileService;
import com.edusn.Digizenger.Demo.security.JWTService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/digizenger/api/v1/profile/")
public class ProfileController {

    private final JWTService jwtService;
    private final UserRepository userRepository;
    private final ProfileService profileService;

    @GetMapping("/test")
    public String test(){
        return "successfully test";
    }

    @GetMapping("/")
    public ResponseEntity<Response> getProfile(HttpServletRequest request){
        String token = jwtService.getJWTFromRequest(request);
        String email = jwtService.extractUsername(token);

        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UserNotFoundException("user cannot found by email : " + email));

        return profileService.showUserProfile(user);

    }
}
