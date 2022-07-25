package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Music;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.GalleryType;
import lombok.Builder;
import lombok.Data;

@Data
public class GalleryDto {

    private String galleryTitle;

    private String galleryContent;

    private GalleryType galleryType;

    private User user;

    private Music music;

//    public Gallery toEntity(){
//        return Gallery.builder()
//                .galleryTitle(galleryTitle)
//                .galleryContents(galleryContent)
//                .galleryType(galleryType)
//                .user(user)
//                .music(music)
//                .build();
//    }
    @Builder
    public GalleryDto(String galleryTitle, String galleryContent, GalleryType galleryType, User user, Music music)
    {
        this.galleryTitle =galleryTitle;
        this.galleryContent = galleryContent;
        this.galleryType = galleryType;
        this.user = user;
        this.music = music;
    }
}
