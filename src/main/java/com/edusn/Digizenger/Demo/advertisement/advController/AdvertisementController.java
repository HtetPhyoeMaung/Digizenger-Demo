package com.edusn.Digizenger.Demo.advertisement.advController;

import com.edusn.Digizenger.Demo.advertisement.advRepository.AdvertisementRepository;
import com.edusn.Digizenger.Demo.advertisement.entity.Advertisement;
import com.edusn.Digizenger.Demo.advertisement.advService.AdvertisementService;
import com.edusn.Digizenger.Demo.auth.dto.response.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/advertisements")
public class AdvertisementController {

 @Autowired
 private AdvertisementService advertisementService;

@PostMapping("/upload")
    public ResponseEntity<Response> upload(@RequestParam("title") String  title
        , @RequestParam("description") String description
        , @RequestParam("file") MultipartFile imageFile
        , HttpServletRequest request) throws IOException {

   return   advertisementService.upload(title ,description,imageFile,request);
}














 //private final AdvertisementService advertisementService;
//    @Autowired
//    public AdvertisementController(AdvertisementService advertisementService) {
//        this.advertisementService = advertisementService;
//    }
//
//    // Fetch all advertisements
//    @GetMapping
//    public List<Advertisement> getAllAdvertisements() {
//        return advertisementService.findAll();
//    }
//
//    // Fetch an advertisement by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable Long id) {
//        Optional<Advertisement> advertisement = advertisementService.findById(id);
//        return advertisement.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // Create a new advertisement
//    @PostMapping
//    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement advertisement) {
//        Advertisement createdAd = advertisementService.save(advertisement);
//        return ResponseEntity.ok(createdAd);
//    }
//
//    // Update an advertisement by ID
//    @PutMapping("/{id}")
//    public ResponseEntity<Advertisement> updateAdvertisement(@PathVariable Long id, @RequestBody Advertisement updatedAd) {
//        try {
//            Advertisement ad = advertisementService.update(id, updatedAd);
//            return ResponseEntity.ok(ad);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Delete an advertisement by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAdvertisement(@PathVariable Long id) {
//        try {
//            advertisementService.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
