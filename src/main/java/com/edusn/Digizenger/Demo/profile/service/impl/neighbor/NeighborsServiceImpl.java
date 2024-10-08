package com.edusn.Digizenger.Demo.profile.service.impl.neighbor;

import com.edusn.Digizenger.Demo.auth.dto.response.Response;
import com.edusn.Digizenger.Demo.auth.entity.User;
import com.edusn.Digizenger.Demo.exception.FollowerNotFoundException;
import com.edusn.Digizenger.Demo.profile.dto.response.otherProfile.RelationShipDto;
import com.edusn.Digizenger.Demo.profile.entity.Profile;
import com.edusn.Digizenger.Demo.profile.repo.ProfileRepository;
import com.edusn.Digizenger.Demo.profile.service.NeighborService;
import com.edusn.Digizenger.Demo.profile.utils.ProfileMapperUtils;
import com.edusn.Digizenger.Demo.utilis.GetUserByRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NeighborsServiceImpl implements NeighborService {

    private final ProfileRepository profileRepository;
    private final ProfileMapperUtils profileMapperUtils;
    private final GetUserByRequest getUserByRequest;

    @Override
    public ResponseEntity<Response> getProfileNeighborsByPage(int _page, int _limit, String profileUrl, HttpServletRequest request) {

        Pageable pageable = PageRequest.of(_page - 1, _limit);
        User user = getUserByRequest.getUser(request);
        Profile profile = profileRepository.findByUser(user);

        if(profile.getProfileLinkUrl() == profileUrl){
            if(profile.getFollowers().isEmpty())
                throw new FollowerNotFoundException("Neighbors are not have in Your profile.");

            Page<Profile> neighborPages = profileRepository.findNeighborsByProfileId(profile.getId(),pageable);
            List<RelationShipDto> profileFollowers = neighborPages.stream().map(
                    neighbor -> profileMapperUtils.convertToRelationShipDto(neighbor)
            ).collect(Collectors.toList());

            Response response = Response.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("successfully got your profile neighbor by url : "+profileUrl)
                    .relationShipDtoList(profileFollowers)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        Profile otherUserProfile = profileRepository.findByProfileLinkUrl(profileUrl);
        if(otherUserProfile.getFollowers() == null)
            throw new FollowerNotFoundException("Neighbors are not found in "
                    +otherUserProfile.getUser().getFirstName()
                    +" "+otherUserProfile.getUser().getLastName()
                    +"'s profile.");
        Page<Profile> neighborPages = profileRepository.findNeighborsByProfileId(otherUserProfile.getId(),pageable);
        List<RelationShipDto> neighbors = neighborPages.stream().map(
                neighbor -> profileMapperUtils.convertToRelationShipDto(neighbor)
        ).collect(Collectors.toList());

        Response response = Response.builder()
                .statusCode(HttpStatus.OK.value())
                .message("successfully got "+ otherUserProfile.getUser().getFirstName()
                        +" "+otherUserProfile.getUser().getLastName()
                        +"'s neighbor.")
                .relationShipDtoList(neighbors)
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
