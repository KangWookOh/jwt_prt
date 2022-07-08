package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.GalleryDto;
import com.cranesch.cranewebbackend.dto.PictureDto;
import com.cranesch.cranewebbackend.dto.VideoDto;
import com.cranesch.cranewebbackend.entity.enums.GalleryType;
import com.cranesch.cranewebbackend.service.GalleryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GalleryTest {
    @Autowired
    private GalleryService galleryService;

    @Test
    public void CreatePicGallery(){
        int photo_num = 3;
        GalleryDto galleryDto = new GalleryDto();
        galleryDto.setGalleryTitle("2022 정기공연 사진");
        galleryDto.setGalleryType(GalleryType.PHOTO);
        galleryDto.setGalleryContent("정기공연 사진입니다.");

        Long gall_id = galleryService.CreateGallery(galleryDto, Long.valueOf(3), Long.valueOf(1));

        for(int i =0; i < photo_num; i++){
            PictureDto pictureDto = new PictureDto();
            pictureDto.setPictureUrl(i + "번째 Url입니다.");
            galleryService.CreatePic(pictureDto, gall_id);
        }
    }

    @Test
    public void CreateVidGallery(){
        GalleryDto galleryDto = new GalleryDto();
        galleryDto.setGalleryTitle("2022 정기공연 1번 곡");
        galleryDto.setGalleryType(GalleryType.VIDEO);
        galleryDto.setGalleryContent("정기공연 1번곡 영상입니다.");

        Long gall_id = galleryService.CreateGallery(galleryDto, Long.valueOf(3), Long.valueOf(1));

        VideoDto videoDto = new VideoDto();
        videoDto.setVideoUrl("영상 Url입니다.");
        galleryService.CreateVid(videoDto, gall_id);
    }

}
