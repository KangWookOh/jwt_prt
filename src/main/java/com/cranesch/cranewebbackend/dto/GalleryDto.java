package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Music;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.GalleryType;
import lombok.Data;

@Data
public class GalleryDto {

    private String galleryTitle;

    private String galleryContent;

    private GalleryType galleryType;

    private User user;

    private Music music;

    public Gallery toEntity(){
        return Gallery.builder()
                .galleryTitle(galleryTitle)
                .galleryContents(galleryContent)
                .galleryType(galleryType)
                .user(user)
                .music(music)
                .build();
    }
}
