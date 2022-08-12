package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.MatchDto;
import com.cranesch.cranewebbackend.dto.MusicDto;
import com.cranesch.cranewebbackend.dto.PerformDto;
import com.cranesch.cranewebbackend.dto.TeamDto;
import com.cranesch.cranewebbackend.entity.*;
import com.cranesch.cranewebbackend.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class PerformService {

    private final PerformRepository performRepository;
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final MusicRepository musicRepository;
    private final UserRepository userRepository;


    @Transactional
    public Long CreatePerform(PerformDto performDto) {
        Perform perform = Perform.builder()
                .performName(performDto.getPerformName())
                .performType(performDto.getPerformType())
                .performDate(performDto.getPerformDate())
                .performPlace(performDto.getPerformPlace())
                .build();
        return performRepository.save(perform).getId();
    }

    @Transactional
    public Long CreateMusic(MusicDto musicDto, Long performId) {
        Optional<Perform> optionalPerform = performRepository.findById(performId);
        if (optionalPerform.isEmpty()) {
            log.info("NoPerform");
        }
        // musicDto.setPerform(optionalPerform.get());
        Music music = Music.builder()
                .musicName(musicDto.getMusicName())
                .musicSinger(musicDto.getMusicSinger())
                .perform(optionalPerform.get())
                .team(musicDto.getTeam())
                .build();
        return musicRepository.save(music).getId();
    }

 /*   @Transactional
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
        *//*sessionDto.setUser(optionalUser.get());
        sessionDto.setMusic(optionalMusic.get());*//*
        PerformSession performSession = PerformSession.builder()
                .session(sessionDto.getSession())
                .user(optionalUser.get())
                .music(optionalMusic.get())
                .build();

        return performSessionRepository.save(performSession).getId();
    }*/

    @Transactional(readOnly = true)
    public List<PerformDto> ReadPerform() {
        List<Perform> performList = performRepository.findAll();
        List<PerformDto> performDtoList = new ArrayList<>();
        if (performList.isEmpty()) {
            throw new EntityExistsException("Perform not exist");
        }
        for (Perform p : performList) {
            PerformDto dto = PerformDto.builder()
                    .performName(p.getPerformName())
                    .performDate(p.getPerformDate())
                    .performPlace(p.getPerformPlace())
                    .performType(p.getPerformType())
                    .build();
            performDtoList.add(dto);
        }
        return performDtoList;
    }

    @Transactional(readOnly = true)
    public List<MusicDto> ReadMusicListByPerform(Long performId) {
        Optional<Perform> optionalPerform = performRepository.findById(performId);
        if (optionalPerform.isEmpty()) {
            throw new EntityExistsException("No perform");
        }
        List<Music> musicList = musicRepository.findByPerformId(performId);
        List<MusicDto> musicDtoList = new ArrayList<>();

        for (Music m : musicList) {
            MusicDto dto = MusicDto.builder()
                    .musicName(m.getMusicName())
                    .musicSinger(m.getMusicSinger())
                    .build();
            musicDtoList.add(dto);
        }

        return musicDtoList;
    }

    /* @Transactional(readOnly = true)
     public List<PerformSession> ReadSessionByMusic(Long musicId){
         Optional<Music> optionalMusic = musicRepository.findById(musicId);
         if(optionalMusic.isEmpty()){
             new EntityExistsException("Music not exist");
         }
         List<PerformSession> pSessionList = performSessionRepository.findByMusicId(musicId);

         return pSessionList;
     }*/
    @Transactional(readOnly = true)
    public TeamDto ReadTeamByMusic(Long musicId) {
        Optional<Music> optionalMusic = musicRepository.findById(musicId);
        if (optionalMusic.isEmpty()) {
            throw new EntityExistsException("Music not exist");
        }
        Team team = optionalMusic.get().getTeam();
        TeamDto dto = TeamDto.builder()
                .teamName(team.getTeamName())
                .teamType(team.getTeamType())
                .isActive(team.getIsActive())
                .build();

        return dto;

    }

    @Transactional(readOnly = true)
    public List<MatchDto> ReadMatchByTeam(Long teamId) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isEmpty()) {
            throw new EntityExistsException("Team Not Exist");
        }
        List<MatchDto> matchDtoList = new ArrayList<>();
        List<Match> matchList = matchRepository.findByTeamId(teamId);
        for (Match m : matchList)
        {
            MatchDto dto = MatchDto.builder()
                    .user(m.getUser())
                    .session(m.getSession())
                    .teamRole(m.getMatchRole())
                    .build();
            matchDtoList.add(dto);
        }
        return matchDtoList;
    }

    @Transactional(readOnly = true)
    public List<MusicDto> ReadMusicByUser(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new EntityExistsException("No user exist");
        }

        List<Match> matchList = matchRepository.findByUserId(userId);
        List<Team> teamList = new ArrayList<>();
        for(Match e : matchList){
            teamList.add(e.getTeam());
        }

        List<Music> musicList = new ArrayList<>();
        for(Team e : teamList){
            List<Music> searchedMusic = musicRepository.findByTeamId(e.getId());
            musicList.addAll(searchedMusic);
        }

        List<MusicDto> dtoList = new ArrayList<>();
        for(Music e : musicList){
            dtoList.add(MusicDto.builder()
                            .musicName(e.getMusicName())
                            .musicSinger(e.getMusicSinger())
                            .perform(e.getPerform())
                            .team(e.getTeam())
                            .build()
            );
        }
        return dtoList;
    }

//        List<Music> musicIdList = new ArrayList<>();
//        Optional<Team> optionalTeam = teamRepository.findByUserId(userId);
//
//        for(PerformSession ps : performSessionList){
//            musicIdList.add(ps.getMusic());
//        }
//
//        List<MusicDto> musicDtoList = new ArrayList<>();
//
//        for(Music m : musicIdList){
//            Optional<Music> optionalMusic = musicRepository.findById(m.getId());
//            if(optionalMusic.isEmpty()){
//                throw new EntityExistsException("no music");
//            }
//            MusicDto dto =MusicDto.builder()
//                    .musicName(m.getMusicName())
//                    .musicSinger(m.getMusicSinger())
//                    .perform(m.getPerform())
//                    .build();
//            musicDtoList.add(dto);
//        }
//
//        return musicDtoList;

   @Transactional
    public void DelPerform(Long performId)
   {
       Optional<Perform> optionalPerform = performRepository.findById(performId);
       if(optionalPerform.isEmpty())
       {
           throw new EntityExistsException("Perform Not Exist");
       }
       List<Music> musicList = musicRepository.findByPerformId(performId);

       for(Music m: musicList)
       {
          musicRepository.deleteById(m.getId());
       }
       performRepository.deleteById(performId);
   }

   @Transactional
    public void DelMusic(Long musicId) {
       Optional<Music> optionalMusic = musicRepository.findById(musicId);
       if (optionalMusic.isEmpty()) {
           throw new EntityExistsException("Music Not Exist");
       }

       musicRepository.deleteById(musicId);
   }

 /*  @Transactional
    public void DelSession(Long sessionId)
   {
       Optional<PerformSession> performSession = performSessionRepository.findById(sessionId);
       performSessionRepository.delete(performSession.get());
   }*/

   @Transactional
    public void updateMusic(Long musicId, MusicDto dto)
   {
       Music music = musicRepository.findById(musicId).orElseThrow(()->new NoSuchElementException("Music Not Exist"));
       music.musicUpdate(dto.getMusicName(), dto.getMusicSinger(), dto.getTeam());
       musicRepository.save(music);
   }

   @Transactional
    public PerformDto updatePerform(Long performId, PerformDto dto){
       Perform perform = performRepository.findById(performId).orElseThrow(() -> new NoSuchElementException("NoPerform"));
       perform.updatePerform(dto.getPerformName(), dto.getPerformPlace(), dto.getPerformDate(), dto.getPerformType());
       performRepository.save(perform);

       return PerformDto.builder()
               .performName(perform.getPerformName())
               .performPlace(perform.getPerformPlace())
               .performDate(perform.getPerformDate())
               .performType(perform.getPerformType())
               .build();
   }

  /* @Transactional
    public void updateSession(Long sessionId,Long userId, PerformSessionDto dto)
   {
       PerformSession session = performSessionRepository.findById(sessionId).orElseThrow(()->new NoSuchElementException("Session Not Exist"));
       User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not exist"));
       session.updateSession(dto.getSession(), session.getMusic(), user);
       performSessionRepository.save(session);
   }*/
}
