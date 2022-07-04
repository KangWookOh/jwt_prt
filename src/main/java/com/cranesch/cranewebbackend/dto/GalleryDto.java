package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Music;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Gallery_Type;
import lombok.Data;

@Data
public class GalleryDto {

    private String gallery_title;

    private String gallery_comtnet;

    private Gallery_Type gallery_type;

    private User user;

    private Music music;

    public Gallery toEntity(){
        return Gallery.builder()
                .Gallery_title(gallery_title)
                .Gallery_contents(gallery_comtnet)
                .Gallery_type(gallery_type)
                .user(user)
                .music(music)
                .build();
    }
}
