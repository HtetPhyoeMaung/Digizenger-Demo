package com.edusn.Digizenger.Demo.advertisement.entity;
import com.edusn.Digizenger.Demo.profile.entity.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "description", length = 255, nullable = true)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "profileId")
    private Profile profile;

    @Column(name = "image_Link_Url", nullable = false)
    private String imageUrl;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;


}
