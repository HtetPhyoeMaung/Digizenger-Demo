package com.edusn.Digizenger.Demo.service.auth;

import com.edusn.Digizenger.Demo.dto.request.LoginRequest;
import com.edusn.Digizenger.Demo.dto.request.RegisterRequest;
import com.edusn.Digizenger.Demo.dto.response.Response;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;


public interface UserService {

    ResponseEntity<Response> register(RegisterRequest request) throws MessagingException;

    ResponseEntity<Response> verifyAccount(String email, String otp);

    ResponseEntity<Response> resendCode(String email) throws MessagingException;

    ResponseEntity<Response> login(LoginRequest request);
}
