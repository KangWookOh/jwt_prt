package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Picture;
import lombok.Data;

@Data
public class PictureDto {

    private String Picture_url;

    private Gallery gallery;

    public Picture toEntity(){
        return Picture.builder()
                .Picture_url(Picture_url)
                .gallery(gallery)
                .build();
    }
}
