package com.edusn.Digizenger.Demo.profile.dto.response.myProfile;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDto {
    private Long id;
    private String profileCareer;
    private String profileImageName;
    private URL profileImageUrl;
    private String coverImageName;
    private URL coverImageUrl;
    private String username;
    private String profileLinkUrl;
    private String bio;
    private Long followers;
    private Long following;
    private Long neighbors;
    private UserForProfileDto userForProfileDto;
    private List<CareerHistoryDto> careerHistoryDtoList = new LinkedList<>();
//    private List<EducationHistoryDto> educationHistoryDtoList = new LinkedList<>();
    private List<ServiceProvidedDto> serviceProvidedDtoList = new LinkedList<>();
}
