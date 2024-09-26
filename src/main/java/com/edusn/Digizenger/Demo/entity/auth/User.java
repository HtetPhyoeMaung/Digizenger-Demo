package com.edusn.Digizenger.Demo.entity.auth;

import com.edusn.Digizenger.Demo.entity.post.Like;
import com.edusn.Digizenger.Demo.entity.post.Post;
import com.edusn.Digizenger.Demo.entity.post.Reply;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(generator = "userSeq")
    @SequenceGenerator(name = "userSeq",initialValue = 100001,allocationSize = 1)
    private Long id;
    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    @Column(nullable = false)
    private String password;

    private Role role;

    private String otp;

    private boolean activated;

    private boolean locked;

    private LocalDateTime validPassDate;

    private LocalDateTime retiredDate;

    private LocalDateTime otpGeneratedTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    private Gender gender;
//    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "user")
    private List<Post> posts;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;



    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "user")
    private List<Like> likes;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "user")
    private List<Reply> replies;

    public enum Gender{
        MALE,
        FEMALE,
        OTHER
    }




}
