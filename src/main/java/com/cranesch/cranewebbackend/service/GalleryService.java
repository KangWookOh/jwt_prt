package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.BoardDto;
import com.cranesch.cranewebbackend.dto.GalleryDto;
import com.cranesch.cranewebbackend.dto.PictureDto;
import com.cranesch.cranewebbackend.dto.VideoDto;
import com.cranesch.cranewebbackend.entity.*;
import com.cranesch.cranewebbackend.entity.enums.BoardState;
import com.cranesch.cranewebbackend.entity.enums.BoardType;
import com.cranesch.cranewebbackend.entity.enums.GalleryType;
import com.cranesch.cranewebbackend.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class GalleryService {
    private BoardRepository boardRepository;
//    private GalleryRepository galleryRepository;
    private UserRepository userRepository;
    private MusicRepository musicRepository;
    private VideoRepository videoRepository;
    private PictureRepository pictureRepository;
    private PerformSessionRepository performSessionRepository;

    @Transactional
    public Long CreateGallery(BoardDto boardDto, Long userId, Long musicId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new EntityExistsException("User is not exist");
        }

        Optional<Music> optionalMusic = musicRepository.findById(musicId);
        if(!optionalMusic.isPresent()){
            throw new EntityExistsException("Music is not exist");
        }

        Board board = Board.builder()
                .boardTitle(boardDto.getBoardTitle())
                .boardType(boardDto.getBoardType())
                .boardState(BoardState.BASIC)
                .boardContents(boardDto.getBoardContents())
                .boardView(0)
                .user(optionalUser.get())
                .music(optionalMusic.get())
                .build();

        return boardRepository.save(board).getId();
    }

    @Transactional
    public Long CreatePic(PictureDto pictureDto, Long boardId){
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if(!optionalBoard.isPresent()){
            throw new EntityExistsException("Board is not exist");
        }

        Picture picture = Picture.builder()
                .pictureUrl(pictureDto.getPictureUrl())
                .board(optionalBoard.get())
                .build();

        return pictureRepository.save(picture).getId();
    }

    @Transactional(readOnly = true)
    public Long CreateVid(VideoDto videoDto, Long boardId){
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if(!optionalBoard.isPresent()){
            throw new EntityExistsException("Board is not exist");
        }

        Video video = Video.builder()
                .videoUrl(videoDto.getVideoUrl())
                .board(optionalBoard.get())
                .build();
        return videoRepository.save(video).getId();
    }

    @Transactional(readOnly = true)
    public List<BoardDto> ReadGalleryAllList()
    {
        List<Board> PicList = boardRepository.findByBoardType(BoardType.PICGALLERY);
        List<Board> VidList = boardRepository.findByBoardType(BoardType.VIDGALLERY);
        PicList.addAll(VidList);
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board b: PicList){
            BoardDto dto = BoardDto.builder()
                    .boardTitle(b.getBoardTitle())
                    .boardContents(b.getBoardContents())
                    .boardState(b.getBoardState())
                    .user(b.getUser())
                    .boardView(b.getBoardView())
                    .music(b.getMusic())
                    .boardType(b.getBoardType())
                    .build();
            boardDtoList.add(dto);
        }

        return boardDtoList;
    }

    //use BoardService > readBoardByType!
//    @Transactional(readOnly = true)
//    public List<GalleryDto> ReadGalleryByType(GalleryType type)
//    {
//        List<Gallery> galleryList;
//        List<GalleryDto> galleryDtoList = new ArrayList<>();
//        if(type == GalleryType.PHOTO)
//        {
//            galleryList = galleryRepository.findBygalleryType(GalleryType.PHOTO);
//        }
//        else
//        {
//            galleryList = galleryRepository.findBygalleryType(GalleryType.VIDEO);
//        }
//
//        for(Gallery g : galleryList) {
//            GalleryDto dto = GalleryDto.builder()
//                    .galleryTitle(g.getGalleryTitle())
//                    .galleryContent(g.getGalleryContent())
//                    .galleryType(g.getGalleryType())
//                    .music(g.getMusic())
//                    .user(g.getUser())
//                    .build();
//
//            galleryDtoList.add(dto);
//        }
//
//        return galleryDtoList;
//    }

    //use BoardService > ReadBoardById!
//    @Transactional
//    public GalleryDto ReadGalleryById(Long id){
//        Optional<Gallery> optionalGallery = galleryRepository.findById(id);
//        Optional<User> optionalUser = userRepository.findById(optionalGallery.get().getUser().getId());
//        if(optionalGallery.isEmpty()){
//            log.info("NoGallery");
//            throw new EntityExistsException("Gallery is not exist");
//        }
//        Gallery gallery = optionalGallery.get();
//
//        return GalleryDto.builder()
//                .galleryTitle(gallery.getGalleryTitle())
//                .galleryContent(gallery.getGalleryContent())
//                .galleryType(gallery.getGalleryType())
//                .user(optionalUser.get())
//                .music(gallery.getMusic())
//                .build();
//    }
    
    @Transactional(readOnly = true)
    public List<PictureDto> ReadGalleryPicture(Long id){
        Optional<Board> optionalBoard = boardRepository.findById(id);
        if(optionalBoard.isEmpty()){
            log.info("NoBoard");
            throw new EntityExistsException("Board is not exist");
        }

            List<PictureDto> pictureDtoList = new ArrayList<>();
            List<Picture> pictureList = pictureRepository.findByboardId(id);

            for(Picture p : pictureList){
                PictureDto dto = PictureDto.builder()
                        .pictureUrl(p.getPictureUrl())
                        .build();
                pictureDtoList.add(dto);
            }

            return pictureDtoList;
    }

    @Transactional(readOnly = true)
    public List<VideoDto> ReadGalleryVideo(Long id){
        Optional<Board> optionalBoard = boardRepository.findById(id);
        if(optionalBoard.isEmpty()){
            log.info("NoGallery");
            throw new EntityExistsException("Gallery is not exist");
        }

        List<VideoDto> videoDtoList = new ArrayList<>();
        List<Video> videoList = videoRepository.findByboardId(id);

        for(Video v : videoList){
            VideoDto dto = VideoDto.builder()
                    .videoUrl(v.getVideoUrl())
                    .build();
            videoDtoList.add(dto);
        }

        return videoDtoList;
    }

    @Transactional(readOnly = true)
    public List<BoardDto> readBoardByMusic(Long musicId){
        Optional<Music> optionalMusic = musicRepository.findById(musicId);
        if(optionalMusic.isEmpty()){
            log.info("Music is not exist");
            throw new EntityExistsException("NoMusic");
        }

        List<Board> boardList = boardRepository.findByMusicId(musicId);
        List<BoardDto> boardDtoList = new ArrayList<>();
        for(Board b : boardList){
            BoardDto dto = BoardDto.builder()
                    .boardTitle(b.getBoardTitle())
                    .boardContents(b.getBoardContents())
                    .boardType(b.getBoardType())
                    .music(optionalMusic.get())
                    .boardView(b.getBoardView())
                    .user(b.getUser())
                    .boardState(b.getBoardState())
                    .build();

            boardDtoList.add(dto);
        }

        return boardDtoList;
    }

//find user by name -> find perform session by user -> find music by perform session -> find gallery by music
    @Transactional
    public List<BoardDto> findGalleryByUser(String userName){
        List<User> userList  = userRepository.findByUserName(userName);

        List<PerformSession> performSessionList = new ArrayList<>();
        for(User u : userList) {
            List<PerformSession> psList = performSessionRepository.findByUserId(u.getId());
            for(PerformSession ps : psList)performSessionList.add(ps);
        }

        List<Music> musicList = new ArrayList<>();
        for(PerformSession ps : performSessionList){
            musicList.add(ps.getMusic());
        }
        //music list distinct
        musicList = musicList.stream().distinct().collect(Collectors.toList());

        List<BoardDto> boardDtoList = new ArrayList<>();
        for(Music m : musicList){
            List<BoardDto> readGalleryDtoByMusic = this.readBoardByMusic(m.getId());
            boardDtoList.addAll(readGalleryDtoByMusic);
        }

        return boardDtoList;
    }


    @Transactional
    public List<BoardDto> findBoardByPerform(Long performId){
        List<Music> musicList = musicRepository.findByPerformId(performId);
        List<Board> galleryList = new ArrayList<>();
        List<BoardDto> galleryDtoList = new ArrayList<>();
        for(Music m : musicList){
            List<Board> readGalleryByMusic = boardRepository.findByMusicId(m.getId());
            galleryList.addAll(readGalleryByMusic);
        }

        for(Board b : galleryList){
            BoardDto dto = BoardDto.builder()
                    .boardTitle(b.getBoardTitle())
                    .boardContents(b.getBoardContents())
                    .boardType(b.getBoardType())
                    .boardState(b.getBoardState())
                    .boardView(b.getBoardView())
                    .user(b.getUser())
                    .music(b.getMusic())
                    .build();
            galleryDtoList.add(dto);
        }
        return galleryDtoList;
    }
}
