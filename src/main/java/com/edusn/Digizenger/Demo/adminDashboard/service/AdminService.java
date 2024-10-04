package com.edusn.Digizenger.Demo.adminDashboard.service;


import com.edusn.Digizenger.Demo.auth.dto.request.RegisterRequest;
import com.edusn.Digizenger.Demo.auth.dto.response.Response;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<Response> register(RegisterRequest registerRequest);
}
