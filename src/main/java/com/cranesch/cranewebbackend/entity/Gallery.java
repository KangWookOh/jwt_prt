package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.GalleryType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String galleryTitle;

    @Column(nullable = false, columnDefinition = "Text")
    private String galleryContent;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GalleryType galleryType;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @JoinColumn(name = "music_id")
    @OneToOne
    Music music;

    @Builder
    public Gallery(String galleryTitle, String galleryContents, GalleryType galleryType, User user, Music music){
        this.galleryTitle = galleryTitle;
        this.galleryContent = galleryContents;
        this.galleryType = galleryType;
        this.user = user;
        this.music = music;
    }
}
