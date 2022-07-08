package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Picture;
import lombok.Data;

@Data
public class PictureDto {

    private String pictureUrl;

    private Gallery gallery;

    public Picture toEntity(){
        return Picture.builder()
                .pictureUrl(pictureUrl)
                .gallery(gallery)
                .build();
    }
}
