package com.edusn.Digizenger.Demo.adminDashboard.service.impl;

import com.edusn.Digizenger.Demo.adminDashboard.entity.Admin;
import com.edusn.Digizenger.Demo.adminDashboard.repository.AdminRepository;
import com.edusn.Digizenger.Demo.adminDashboard.service.AdminService;
import com.edusn.Digizenger.Demo.auth.dto.request.RegisterRequest;
import com.edusn.Digizenger.Demo.auth.dto.response.Response;
import com.edusn.Digizenger.Demo.exception.LoginNameExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public ResponseEntity<Response> register(RegisterRequest registerRequest) {

            Optional<Admin> existAdmin = adminRepository.findByEmail(registerRequest.getEmail());
            if(existAdmin.isPresent()) {
                throw new LoginNameExistException("Email A")

            }

        return null;
    }
}
