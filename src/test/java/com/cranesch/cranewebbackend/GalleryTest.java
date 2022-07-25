package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.GalleryDto;
import com.cranesch.cranewebbackend.dto.PictureDto;
import com.cranesch.cranewebbackend.dto.VideoDto;
import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Picture;
import com.cranesch.cranewebbackend.entity.enums.GalleryType;
import com.cranesch.cranewebbackend.service.GalleryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GalleryTest {
    @Autowired
    private GalleryService galleryService;

    @Test
    public void CreatePicGallery(){
        int photo_num = 3;
        GalleryDto galleryDto = GalleryDto.builder()
                .galleryTitle("2022 정기공연 사진")
                .galleryContent("정기공연 사진입니다")
                .galleryType(GalleryType.PHOTO)
                .build();

        Long gall_id = galleryService.CreateGallery(galleryDto, Long.valueOf(3), Long.valueOf(1));

        for(int i =1; i <= photo_num; i++){
            PictureDto pictureDto = PictureDto.builder()
                            .pictureUrl(i + "번째 URL 입니다.")
                            .build();
            galleryService.CreatePic(pictureDto, gall_id);
        }
    }

    @Test
    public void CreateVidGallery(){
        GalleryDto galleryDto = GalleryDto.builder()
                    .galleryTitle("2022 정기공연1")
                    .galleryContent("2022 정기공연 1번팀 공연 영상입니다.")
                    .galleryType(GalleryType.VIDEO)
                    .build();

        Long gall_id = galleryService.CreateGallery(galleryDto, Long.valueOf(3), Long.valueOf(1));

        VideoDto videoDto = VideoDto.builder()
                .videoUrl("영상 URL 입니다")
                .build();
        galleryService.CreateVid(videoDto, gall_id);
    }

    @Test
    public void ReadGalleryAllList(){
        List<GalleryDto> galleryDtoList = galleryService.ReadGalleryAllList();

        for(GalleryDto g : galleryDtoList){
            System.out.printf("[" + g.getGalleryType() + "]" + "제목: " + g.getGalleryTitle() + " / 내용: " + g.getGalleryContent() + "\n");
        }
    }
    @Test
    public void ReadGalleryByType(){
        GalleryType gtype = GalleryType.PHOTO;
        List<GalleryDto> galleryDtoList = galleryService.ReadGalleryByType(gtype);

        System.out.println("< " + gtype + " >의 Gallery 게시물 입니다\n");
        for(GalleryDto g : galleryDtoList){
            System.out.println("제목: " + g.getGalleryTitle() + " / 내용: " + g.getGalleryContent() + "작성자: " + g.getUser().getUserName() + "\n");
        }
    }

    //Read Gallery By gallery id with contents(pics or vids)
    @Test
    public void ReadGalleryById(){
        Long id = 1L;
        GalleryDto dto = galleryService.ReadGalleryById(id);

        System.out.println("제목: " + dto.getGalleryTitle() + "   작성자: " + dto.getUser().getUserName());
        System.out.println("내용: " + dto.getGalleryContent());

        List<PictureDto> pictureDtoList = new ArrayList<>();
        List<VideoDto> videoDtoList = new ArrayList<>();
        if(dto.getGalleryType() == GalleryType.PHOTO){
            pictureDtoList = galleryService.ReadGalleryPicture(id);
            int i = 1;
            for(PictureDto p : pictureDtoList){
                System.out.println(i++ + "번째 사진 링크 : " + p.getPictureUrl());
            }
        }else {
            videoDtoList = galleryService.ReadGalleryVideo(id);
            int i = 1;
            for(VideoDto v : videoDtoList){
                System.out.println(i++ + "번째 사진 링크 : " + v.getVideoUrl());
            }
        }
    }

    @Test
    public void ReadGalleryByMusicId(){
        List<GalleryDto> galleryDtoList = galleryService.readGalleryByMusic(1L);

        for(GalleryDto g : galleryDtoList){
            System.out.println("[" + g.getGalleryType() + "] 제목: " + g.getGalleryTitle() + "내용 : " + g.getGalleryContent());
        }
    }

    @Test
    public void ReadGalleryByUsername() {
        String username = "명혜성";
        List<GalleryDto> galleryDtoList = galleryService.findGalleryByUser(username);

        int i = 1;
        System.out.printf("부원 " + username + " 에 대한 검색 결과입니다\n");
        for(GalleryDto g : galleryDtoList){
            System.out.println(i++ + " [" + g.getGalleryType() + "] 제목:" +g.getGalleryTitle() + "/ 내용:" + g.getGalleryContent());
        }
    }

    @Test
    public void ReadGalleryByPerform()
    {
        Long performId = 3L;
        List<GalleryDto> galleryDtoList = galleryService.findGalleryByPerform(performId);
        int i =1;
        System.out.println("공연 Id "+ performId + "의 갤러리");
        for(GalleryDto g: galleryDtoList)
        {
            System.out.println(i++ + "Gallery Name : "+ g.getGalleryTitle() + " \nGallery Content : " + g.getGalleryContent()
            +"\nGallery Type : "+ g.getGalleryType());
            System.out.println("----------------------------");
        }
    }
}
