package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.GalleryDto;
import com.cranesch.cranewebbackend.dto.PictureDto;
import com.cranesch.cranewebbackend.dto.VideoDto;
import com.cranesch.cranewebbackend.entity.*;
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

    private GalleryRepository galleryRepository;
    private UserRepository userRepository;
    private MusicRepository musicRepository;
    private VideoRepository videoRepository;
    private PictureRepository pictureRepository;
    private PerformSessionRepository performSessionRepository;

    @Transactional
    public Long CreateGallery(GalleryDto galleryDto, Long userId, Long musicId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new EntityExistsException("User is not exist");
        }

        Optional<Music> optionalMusic = musicRepository.findById(musicId);
        if(!optionalMusic.isPresent()){
            throw new EntityExistsException("Music is not exist");
        }

        Gallery gallery = Gallery.builder()
                .galleryTitle(galleryDto.getGalleryTitle())
                .galleryContents(galleryDto.getGalleryContent())
                .galleryType(galleryDto.getGalleryType())
                .music(optionalMusic.get())
                .user(optionalUser.get())
                .build();

        return galleryRepository.save(gallery).getId();
    }

    @Transactional
    public Long CreatePic(PictureDto pictureDto, Long galleryId){
        Optional<Gallery> optionalGallery = galleryRepository.findById(galleryId);
        if(!optionalGallery.isPresent()){
            throw new EntityExistsException("Gallery is not exist");
        }

        Picture picture = Picture.builder()
                .pictureUrl(pictureDto.getPictureUrl())
                .gallery(optionalGallery.get())
                .build();

        return pictureRepository.save(picture).getId();
    }

    @Transactional(readOnly = true)
    public Long CreateVid(VideoDto videoDto, Long galleryId){
        Optional<Gallery> optionalGallery = galleryRepository.findById(galleryId);
        if(!optionalGallery.isPresent()){
            throw new EntityExistsException("Gallery is not exist");
        }

        Video video = Video.builder()
                .videoUrl(videoDto.getVideoUrl())
                .gallery(optionalGallery.get())
                .build();
        return videoRepository.save(video).getId();
    }
    @Transactional(readOnly = true)
    public List<GalleryDto> ReadGalleryAllList()
    {
        List<Gallery> galleryList = galleryRepository.findAll();
        List<GalleryDto> galleryDtoList = new ArrayList<>();

        for(Gallery g: galleryList){
            GalleryDto dto = GalleryDto.builder()
                    .galleryTitle(g.getGalleryTitle())
                    .galleryContent(g.getGalleryContent())
                    .galleryType(g.getGalleryType())
                    .user(g.getUser())
                    .music(g.getMusic())
                    .build();

            galleryDtoList.add(dto);
        }

        return galleryDtoList;
    }
    @Transactional(readOnly = true)
    public List<GalleryDto> ReadGalleryByType(GalleryType type)
    {
        List<Gallery> galleryList;
        List<GalleryDto> galleryDtoList = new ArrayList<>();
        if(type == GalleryType.PHOTO)
        {
            galleryList = galleryRepository.findBygalleryType(GalleryType.PHOTO);
        }
        else
        {
            galleryList = galleryRepository.findBygalleryType(GalleryType.VIDEO);
        }

        for(Gallery g : galleryList) {
            GalleryDto dto = GalleryDto.builder()
                    .galleryTitle(g.getGalleryTitle())
                    .galleryContent(g.getGalleryContent())
                    .galleryType(g.getGalleryType())
                    .music(g.getMusic())
                    .user(g.getUser())
                    .build();

            galleryDtoList.add(dto);
        }

        return galleryDtoList;
    }

    @Transactional
    public GalleryDto ReadGalleryById(Long id){
        Optional<Gallery> optionalGallery = galleryRepository.findById(id);
        Optional<User> optionalUser = userRepository.findById(optionalGallery.get().getUser().getId());
        if(optionalGallery.isEmpty()){
            log.info("NoGallery");
            throw new EntityExistsException("Gallery is not exist");
        }
        Gallery gallery = optionalGallery.get();
        
        return GalleryDto.builder()
                .galleryTitle(gallery.getGalleryTitle())
                .galleryContent(gallery.getGalleryContent())
                .galleryType(gallery.getGalleryType())
                .user(optionalUser.get())
                .music(gallery.getMusic())
                .build();
    }
    
    @Transactional(readOnly = true)
    public List<PictureDto> ReadGalleryPicture(Long id){
        Optional<Gallery> optionalGallery = galleryRepository.findById(id);
        if(optionalGallery.isEmpty()){
            log.info("NoGallery");
            throw new EntityExistsException("Gallery is not exist");
        }

            List<PictureDto> pictureDtoList = new ArrayList<>();
            List<Picture> pictureList = pictureRepository.findBygalleryId(id);

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
        Optional<Gallery> optionalGallery = galleryRepository.findById(id);
        if(optionalGallery.isEmpty()){
            log.info("NoGallery");
            throw new EntityExistsException("Gallery is not exist");
        }

        List<VideoDto> videoDtoList = new ArrayList<>();
        List<Video> videoList = videoRepository.findBygalleryId(id);

        for(Video v : videoList){
            VideoDto dto = VideoDto.builder()
                    .videoUrl(v.getVideoUrl())
                    .build();
            videoDtoList.add(dto);
        }

        return videoDtoList;
    }

    @Transactional(readOnly = true)
    public List<GalleryDto> readGalleryByMusic(Long musicId){
        Optional<Music> optionalMusic = musicRepository.findById(musicId);
        if(optionalMusic.isEmpty()){
            log.info("Music is not exist");
            throw new EntityExistsException("NoMusic");
        }

        List<Gallery> galleryList = galleryRepository.findByMusicId(musicId);
        List<GalleryDto> galleryDtoList = new ArrayList<>();
        for(Gallery g : galleryList){
            GalleryDto dto = GalleryDto.builder()
                    .galleryTitle(g.getGalleryTitle())
                    .galleryContent(g.getGalleryContent())
                    .galleryType(g.getGalleryType())
                    .music(optionalMusic.get())
                    .user(g.getUser())
                    .build();

            galleryDtoList.add(dto);
        }

        return galleryDtoList;
    }

//find user by name -> find perform session by user -> find music by perform session -> find gallery by music
    @Transactional
    public List<GalleryDto> findGalleryByUser(String userName){
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

        List<GalleryDto> galleryDtoList = new ArrayList<>();
        for(Music m : musicList){
            List<GalleryDto> readGalleryDtoByMusic = this.readGalleryByMusic(m.getId());
            galleryDtoList.addAll(readGalleryDtoByMusic);
        }

        return galleryDtoList;

    }


    @Transactional
    public List<GalleryDto> findGalleryByPerform(Long performId){
        List<Music> musicList = musicRepository.findByPerformId(performId);
        List<Gallery> galleryList = new ArrayList<>();
        List<GalleryDto> galleryDtoList = new ArrayList<>();
        for(Music m : musicList){
            List<Gallery> readGalleryByMusic = galleryRepository.findByMusicId(m.getId());
            galleryList.addAll(readGalleryByMusic);
        }

        for(Gallery g : galleryList){
            GalleryDto dto = GalleryDto.builder()
                    .galleryTitle(g.getGalleryTitle())
                    .galleryContent(g.getGalleryContent())
                    .galleryType(g.getGalleryType())
                    .user(g.getUser())
                    .music(g.getMusic())
                    .build();
            galleryDtoList.add(dto);
        }
        return galleryDtoList;
    }
}
