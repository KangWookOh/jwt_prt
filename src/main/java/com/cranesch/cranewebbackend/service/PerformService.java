package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.MusicDto;
import com.cranesch.cranewebbackend.dto.PerformDto;
import com.cranesch.cranewebbackend.dto.PerformSessionDto;
import com.cranesch.cranewebbackend.entity.Music;
import com.cranesch.cranewebbackend.entity.Perform;
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
        return performRepository.save(performDto.toEntity()).getPerformId();
    }

    @Transactional
    public Long CreateMusic(MusicDto musicDto, Long performId)
    {
        Optional<Perform> optionalPerform = performRepository.findById(performId);
        if(optionalPerform.isEmpty()){
            throw new EntityExistsException("Perform Not Exist");
        }
        musicDto.setPerform(optionalPerform.get());
    return musicRepository.save(musicDto.toEntity()).getMusicId();

    }
    @Transactional
    public Long CreatePerformSession(PerformSessionDto sessionDto, Long userId, Long musicId)
    {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new EntityExistsException("User Not Found");
        }
        Optional<Music> optionalMusic = musicRepository.findById(musicId);
        if(optionalMusic.isEmpty()){
            throw new EntityExistsException("Music Not Found");
        }
        sessionDto.setUser(optionalUser.get());
        sessionDto.setMusic(optionalMusic.get());

        return performSessionRepository.save(sessionDto.toEntity()).getPerformSessionId();
    }
}
