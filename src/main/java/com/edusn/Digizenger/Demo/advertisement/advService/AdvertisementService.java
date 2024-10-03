package com.edusn.Digizenger.Demo.advertisement.advService;
import com.edusn.Digizenger.Demo.advertisement.advRepository.AdvertisementRepository;
import com.edusn.Digizenger.Demo.advertisement.entity.Advertisement;
import com.edusn.Digizenger.Demo.auth.dto.response.Response;
import com.edusn.Digizenger.Demo.auth.entity.User;
import com.edusn.Digizenger.Demo.profile.dto.response.myProfile.ProfileDto;
import com.edusn.Digizenger.Demo.storage.StorageService;
import com.edusn.Digizenger.Demo.utilis.GetUserByRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private StorageService storageService;
    @Autowired
    private GetUserByRequest getUserByRequest;

    public ResponseEntity<Response> upload(@RequestParam("title") String  title
            , @RequestParam("description") String description
            , @RequestParam("file") MultipartFile imageFile
            , HttpServletRequest request) throws IOException {

           User user = getUserByRequest.getUser(request);

           String fileName = storageService.uploadImage(imageFile);
          URL fileUrl= storageService.getImageByName(fileName);
          String imageUrl = fileUrl.toString();

            Advertisement advertisement = Advertisement.builder()
                    .title(title)
                    .createdDate(LocalDateTime.now())
                    .description(description)
                    .imageUrl(imageUrl)
                    .profile(user.getProfile())
                    .build();

                advertisementRepository.save(advertisement);
                   ProfileDto profileDto = ProfileDto.builder()
                           .profileLinkUrl(user.getProfile().getProfileLinkUrl())
                           .build();

                Response response = Response.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Advertisement Create Success!")
                        .profileDto(profileDto)
                        .build();
                return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
