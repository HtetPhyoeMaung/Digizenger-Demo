package com.edusn.Digizenger.Demo.adminDashboard.entity;

import com.edusn.Digizenger.Demo.auth.entity.Address;
import com.edusn.Digizenger.Demo.auth.entity.User;
import com.edusn.Digizenger.Demo.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
    private String phone;
    @Column(nullable = false)
    private String password;

    private String role;

    private String otp;

    private boolean activated;

    private boolean locked;

    private LocalDateTime validPassDate;

    private LocalDateTime retiredDate;

    private LocalDateTime otpGeneratedTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    private User.Gender gender;

    private LocalDateTime createdDate;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

}
