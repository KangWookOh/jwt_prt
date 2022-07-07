package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.MusicDto;
import com.cranesch.cranewebbackend.dto.PerformDto;
import com.cranesch.cranewebbackend.dto.PerformSessionDto;
import com.cranesch.cranewebbackend.entity.Music;
import com.cranesch.cranewebbackend.entity.Perform;
import com.cranesch.cranewebbackend.entity.PerformSession;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.MusicRepository;
import com.cranesch.cranewebbackend.repository.PerformRepository;
import com.cranesch.cranewebbackend.repository.PerformSessionRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PerformService {

    private PerformRepository performRepository;
    private PerformSessionRepository performSessionRepository;
    private MusicRepository musicRepository;
    private UserRepository userRepository;

    @Transactional
    public Long CreatePerform(PerformDto performDto){
        return performRepository.save(performDto.toEntity()).getPerform_id();
    }

    @Transactional
    public Long CreateMusic(MusicDto musicDto, Long Perform_id)
    {
        Optional<Perform> optionalPerform = performRepository.findById(Perform_id);
        if(optionalPerform.isEmpty()){
            throw new EntityExistsException("Perform Not Exist");
        }
        musicDto.setPerform(optionalPerform.get());
    return musicRepository.save(musicDto.toEntity()).getMusic_id();

    }
    @Transactional
    public Long CreatePerformSession(PerformSessionDto sessionDto, Long User_id, Long Music_id)
    {
        Optional<User> optionalUser = userRepository.findById(User_id);
        if(!optionalUser.isPresent()){
            throw new EntityExistsException("User Not Found");
        }
        Optional<Music> optionalMusic = musicRepository.findById(Music_id);
        if(!optionalMusic.isPresent()){
            throw new EntityExistsException("Music Not Found");
        }
        sessionDto.setUser(optionalUser.get());
        sessionDto.setMusic(optionalMusic.get());

        return performSessionRepository.save(sessionDto.toEntity()).getPerformSession_id();
    }
}
