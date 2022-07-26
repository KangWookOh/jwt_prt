package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Picture;
import lombok.Builder;
import lombok.Data;

@Data
public class PictureDto {

    private String pictureUrl;

    private Board board;

//    public Picture toEntity(){
//        return Picture.builder()
//                .pictureUrl(pictureUrl)
//                .gallery(gallery)
//                .build();
//    }
    @Builder
    public PictureDto (String pictureUrl, Board board)
    {
        this.pictureUrl = pictureUrl;
        this.board = board;
    }
}
