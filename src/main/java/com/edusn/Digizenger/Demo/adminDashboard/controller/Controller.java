package com.edusn.Digizenger.Demo.adminDashboard.controller;

import com.edusn.Digizenger.Demo.adminDashboard.service.AdminService;
import com.edusn.Digizenger.Demo.auth.dto.request.RegisterRequest;
import com.edusn.Digizenger.Demo.auth.dto.response.Response;
import com.edusn.Digizenger.Demo.post.service.PostService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/admin/")
@RequiredArgsConstructor
public class Controller {

        private final AdminService adminService;

        public ResponseEntity<Response> register(@RequestBody RegisterRequest registerRequest ){

            return adminService.register (registerRequest);

        }

}
