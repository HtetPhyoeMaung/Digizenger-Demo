package com.edusn.Digizenger.Demo.auth.dto.response;

import com.edusn.Digizenger.Demo.post.dto.PostDto;
import com.edusn.Digizenger.Demo.profile.dto.response.ProfileDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int statusCode;

    private String message;

    private String token;

    private String  role;

    private String otp;
    private List<PostDto> postDto;


    private String expirationDate;

    private ProfileDto profileDto;


}
