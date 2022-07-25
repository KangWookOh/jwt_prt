package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Picture;
import lombok.Builder;
import lombok.Data;

@Data
public class PictureDto {

    private String pictureUrl;

    private Gallery gallery;

//    public Picture toEntity(){
//        return Picture.builder()
//                .pictureUrl(pictureUrl)
//                .gallery(gallery)
//                .build();
//    }
    @Builder
    public PictureDto (String pictureUrl, Gallery gallery)
    {
        this.pictureUrl = pictureUrl;
        this.gallery = gallery;
    }
}
