package com.edusn.Digizenger.Demo.utilis;

import com.edusn.Digizenger.Demo.auth.entity.User;
import com.edusn.Digizenger.Demo.post.dto.PostDto;
import com.edusn.Digizenger.Demo.post.dto.UserDto;
import com.edusn.Digizenger.Demo.post.entity.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MapperUtil {


    public static PostDto convertToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setDescription(post.getDescription());
        postDto.setCreatedDate(post.getCreatedDate());
        postDto.setModifiedDate(post.getModifiedDate());
        postDto.setPostType(post.getPostType());
        postDto.setViewCount(post.getViewsCount());
        postDto.setLikeCount(post.getLikesCount());

        return postDto;
    }
    public static UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setFollowers(user.getFollowers());
        userDto.setProfileImage(user.getProfile().getProfileImageName());
        userDto.setUserProfileUrlLink(user.getProfile().getProfileLinkUrl());

        return userDto;
    }


}
