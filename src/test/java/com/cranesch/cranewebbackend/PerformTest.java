package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.MatchDto;
import com.cranesch.cranewebbackend.dto.MusicDto;
import com.cranesch.cranewebbackend.dto.PerformDto;
import com.cranesch.cranewebbackend.dto.TeamDto;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.enums.PerformType;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.service.PerformService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PerformTest {
    @Autowired
    private PerformService performService;

    @Test
    public void PerformCreateTest(){
        PerformDto performDto = PerformDto.builder()
                .performName("2022 벚꽃축제")
                .performDate(LocalDateTime.of(2022, 01,01,15,00,00))
                .performPlace("오광")
                .performType(PerformType.REGULAR)
                .build();

        performService.CreatePerform(performDto);
    }

    @Test
    public void MusicCreateTest()
    {
        MusicDto musicDto = MusicDto.builder()
                .musicName("있잖아")
                .musicSinger("아이유")
                .build();

        performService.CreateMusic(musicDto,Long.valueOf(4));
    }

  /*  @Test
    public void SessionCreateTest()
    {
        PerformSessionDto sessionDto = PerformSessionDto.builder()
                .session(Session.GUITAR)
                .build();

        performService.CreatePerformSession(sessionDto, Long.valueOf(1),Long.valueOf(4));
    }*/

    @Test
    public void ReadPerformTest()
    {
        List<PerformDto> plist = performService.ReadPerform();
        for(PerformDto p : plist)
        {
            System.out.printf("Perform name :" + p.getPerformName() + " / PerformType :" + p.getPerformType()
                    + " / Perform Place :" + p.getPerformPlace()+ "\n");
        }
    }

    @Test
    public void ReadMusicByPerform(){
        Long performId = Long.valueOf(2);
        List<MusicDto> musicList = performService.ReadMusicListByPerform(performId);

        System.out.printf("공연 ID" + performId + "의 셋리 \n");

        int i = 1;
        for(MusicDto m : musicList){
            System.out.printf(i++ + ") 곡 명: " + m.getMusicName() + "  가수: " + m.getMusicSinger() + "\n");
        }
    }

    @Test
    public void ReadMusicByUser(){
        Long userId = Long.valueOf(1);
        List<MusicDto> musicDtoListList = performService.ReadMusicByUser(userId);

        System.out.printf("userid: " + userId + "의 참가 공연 목록\n");
        int i = 1;
        for(MusicDto m : musicDtoListList){
            System.out.printf(i++ + ") 곡명: " + m.getMusicName()
                    + "  가수: " + m.getMusicSinger() + "\n");
        }
    }

    @Test
    public void ReadTeamByMusic()
    {
        TeamDto teamDto = performService.ReadTeamByMusic(Long.valueOf(1));

            System.out.println("Team Type: " + teamDto.getTeamType() + " / Team Name: "+teamDto.getTeamName()+"\n");
    }

    @Test
    public void ReadMatchByTeam()
    {
        List<MatchDto> matchDtoList = performService.ReadMatchByTeam(1L);

        for(MatchDto m: matchDtoList)
        {
            System.out.println("Name : "+ m.getUser().getUsername() + " / Session : "+ m.getSession() + " / Match Role : "+ m.getTeamRole() + "\n");
        }
    }

    @Test
    public void DelPerformTest()
    {
        Long performId = 3L;
        performService.DelPerform(performId);
    }

    @Test
    public void DelMusicTest()
    {
        Long musicId = 1L;
        performService.DelMusic(musicId);
    }

//    @Test
//    public void DelSessionTest()
//    {
//        Long sessionId = 1L;
//        performService.DelSession(sessionId);
//    }

    @Test
    public void UpdateMusicTest()
    {
        Long musicId = 4L;
        MusicDto dto = MusicDto.builder()
                .musicName("고백직전")
                .musicSinger("소란")
                .build();
        performService.updateMusic(musicId, dto);
    }

//    @Test
//    public void UpdateSessionTest()
//    {
//        Long musicId = 5L;
//        Long userId = 3L;
//        PerformSessionDto dto = PerformSessionDto.builder()
//                .session(Session.KEYBOARD)
//                .build();
//        performService.updateSession(musicId, userId, dto);
//    }

    @Test
    public void UpdatePerformTest(){
        Long performId = 2L;
        PerformDto performDto = PerformDto.builder()
                .performName("new performName")
                .performDate(LocalDateTime.of(2000,01,01,00,00,00))
                .performPlace("new Place")
                .performType(PerformType.OUTSIDE)
                .build();
        performService.updatePerform(performId, performDto);
    }
}
