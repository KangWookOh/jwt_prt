package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Video;
import lombok.Builder;
import lombok.Data;

@Data
public class VideoDto {

    private String videoUrl;

    private Board board;

//    public Video toEntity(){
//        return Video.builder()
//                .videoUrl(videoUrl)
//                .gallery(gallery)
//                .build();
//    }

    @Builder
    public VideoDto(String videoUrl,Board board)
    {
        this.videoUrl=videoUrl;
        this.board=board;
    }
}
