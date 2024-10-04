package com.edusn.Digizenger.Demo.adminDashboard.repository;

import com.edusn.Digizenger.Demo.adminDashboard.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository <Admin, Long> {
    Optional<Admin> findByEmail(String email);
}
