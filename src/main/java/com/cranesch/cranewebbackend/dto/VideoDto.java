package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Video;
import lombok.Data;

@Data
public class VideoDto {

    private String videoUrl;

    private Gallery gallery;

    public Video toEntity(){
        return Video.builder()
                .videoUrl(videoUrl)
                .gallery(gallery)
                .build();
    }
}
