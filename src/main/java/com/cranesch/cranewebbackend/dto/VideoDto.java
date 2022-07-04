package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Video;
import lombok.Data;

@Data
public class VideoDto {

    private String Video_url;

    private Gallery gallery;

    public Video toEntity(){
        return Video.builder()
                .Video_url(Video_url)
                .gallery(gallery)
                .build();
    }
}
