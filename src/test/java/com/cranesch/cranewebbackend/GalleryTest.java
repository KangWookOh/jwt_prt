package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.BoardDto;
import com.cranesch.cranewebbackend.dto.GalleryDto;
import com.cranesch.cranewebbackend.dto.PictureDto;
import com.cranesch.cranewebbackend.dto.VideoDto;
import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Picture;
import com.cranesch.cranewebbackend.entity.enums.BoardState;
import com.cranesch.cranewebbackend.entity.enums.BoardType;
import com.cranesch.cranewebbackend.entity.enums.GalleryType;
import com.cranesch.cranewebbackend.service.BoardService;
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
    @Autowired
    private BoardService boardService;

    @Test
    public void CreatePicGallery(){
        int photo_num = 3;
        BoardDto boardDto = BoardDto.builder()
                .boardTitle("2022 정기공연 사진")
                .boardContents("정기공연 사진 3장입니다.")
                .boardType(BoardType.PICGALLERY)
                .boardState(BoardState.BASIC)
                .build();
        Long gall_id = galleryService.CreateGallery(boardDto, Long.valueOf(3), Long.valueOf(4));

        for(int i =1; i <= photo_num; i++){
            PictureDto pictureDto = PictureDto.builder()
                            .pictureUrl(i + "번째 URL 입니다.")
                            .build();
            galleryService.CreatePic(pictureDto, gall_id);
        }
    }

    @Test
    public void CreateVidGallery(){
        BoardDto boardDto = BoardDto.builder()
                .boardTitle("2022 정기공연1")
                .boardContents("2022 정기공연 1번팀 공연 영상입니다.")
                .boardType(BoardType.VIDGALLERY)
                .build();

        Long gall_id = galleryService.CreateGallery(boardDto, Long.valueOf(3), Long.valueOf(4));

        VideoDto videoDto = VideoDto.builder()
                .videoUrl("영상 URL 입니다")
                .build();
        galleryService.CreateVid(videoDto, gall_id);
    }

    @Test
    public void ReadGalleryAllList(){
        List<BoardDto> boardDtoList = galleryService.ReadGalleryAllList();

        for(BoardDto b : boardDtoList){
            System.out.printf("[" + b.getBoardType() + "]" + "제목: " + b.getBoardTitle() + " / 내용: " + b.getBoardContents() + "\n");
        }
    }
    @Test
    public void ReadGalleryByType(){
        BoardType btype = BoardType.PICGALLERY;
        List<BoardDto> boardDtoList = boardService.ReadBoardByType(btype);

        System.out.println("< " + btype + " >의 Gallery 게시물 입니다\n");
        for(BoardDto b : boardDtoList){
            System.out.println("제목: " + b.getBoardTitle() + " / 내용: " + b.getBoardContents() + "작성자: " /*+ b.getUser().getUserName()*/ + "\n");
        }
    }

    //Read Gallery By gallery id with contents(pics or vids)
   /* @Test
    public void ReadGalleryById(){
        Long id = 1L;
        BoardDto dto = galleryService.findGalleryByUser(id);

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
    }*/

    @Test
    public void ReadGalleryByMusicId(){
        List<BoardDto> galleryDtoList = galleryService.readBoardByMusic(1L);

        for(BoardDto b : galleryDtoList){
            System.out.println("[" + b.getBoardType() + "] 제목: " + b.getBoardTitle() + "내용 : " + b.getBoardContents());
        }
    }

    @Test
    public void ReadGalleryByUsername() {
        String username = "명혜성";
        List<BoardDto> boardDtoList = galleryService.findGalleryByUser(username);

        int i = 1;
        System.out.printf("부원 " + username + " 에 대한 검색 결과입니다\n");
        for(BoardDto b : boardDtoList){
            System.out.println(i++ + " [" + b.getBoardType() + "] 제목:" +b.getBoardTitle() + "/ 내용:" + b.getBoardContents());
        }
    }

    @Test
    public void ReadGalleryByPerform()
    {
        Long performId = 3L;
        List<BoardDto> boardDtoList = galleryService.findBoardByPerform(performId);
        int i =1;
        System.out.println("공연 Id "+ performId + "의 갤러리");
        for(BoardDto b: boardDtoList)
        {
            System.out.println(i++ + "Gallery Name : "+ b.getBoardTitle() + " \nGallery Content : " + b.getBoardContents()
            +"\nGallery Type : "+ b.getBoardType());
            System.out.println("----------------------------");
        }
    }

    @Test
    public void PictureDeleteTest(){
        Long pictureId = 1L;
        galleryService.DeletePic(pictureId);
    }

    @Test
    public void VideoDeleteTest(){
        Long videoId =1L;
        galleryService.DeleteVid(videoId);
    }

    @Test
    public void DeleteGalleryBoard(){
        Long galleryId = 1L;
        galleryService.DeleteGalleryBoard(galleryId);
    }

    @Test
    public void UpdatePic(){
        Long picId = 1L;
        PictureDto pictureDto = PictureDto.builder()
                .pictureUrl("updated pic url")
                .build();

        galleryService.updatePicture(picId, pictureDto);
    }

    @Test
    public void UpdateVid(){
        Long vidId = 1L;
        VideoDto videoDto = VideoDto.builder()
                .videoUrl("updated video url")
                .build();

        galleryService.updateVideo(vidId,videoDto);
    }
}
