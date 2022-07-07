package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.GalleryDto;
import com.cranesch.cranewebbackend.dto.PictureDto;
import com.cranesch.cranewebbackend.dto.UserDto;
import com.cranesch.cranewebbackend.dto.VideoDto;
import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.Music;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GalleryService {

    private GalleryRepository galleryRepository;
    private UserRepository userRepository;
    private MusicRepository musicRepository;
    private VideoRepository videoRepository;
    private PictureRepository pictureRepository;

    @Transactional
    public Long CreateGallery(GalleryDto galleryDto, Long user_id, Long music_id){
        Optional<User> optionaluser = userRepository.findById(user_id);
        if(!optionaluser.isPresent()){
            throw new EntityExistsException("User is not exist");
        }

        Optional<Music> optionalMusic = musicRepository.findById(music_id);
        if(!optionalMusic.isPresent()){
            throw new EntityExistsException("Music is not exist");
        }

        galleryDto.setMusic(optionalMusic.get());
        galleryDto.setUser(optionaluser.get());

        return galleryRepository.save(galleryDto.toEntity()).getGallery_id();
    }

    @Transactional
    public Long CreatePic(PictureDto pictureDto, Long gallery_id){
        Optional<Gallery> optionalGallery = galleryRepository.findById(gallery_id);
        if(!optionalGallery.isPresent()){
            throw new EntityExistsException("Gallery is not exist");
        }
        pictureDto.setGallery(optionalGallery.get());

        return pictureRepository.save(pictureDto.toEntity()).getPicture_id();
    }

    @Transactional
    public Long CreateVid(VideoDto videoDto, Long gallery_id){
        Optional<Gallery> optionalGallery = galleryRepository.findById(gallery_id);
        if(!optionalGallery.isPresent()){
            throw new EntityExistsException("Gallery is not exist");
        }
        videoDto.setGallery(optionalGallery.get());

        return videoRepository.save(videoDto.toEntity()).getVideo_id();
    }

}
