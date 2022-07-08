package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.MusicDto;
import com.cranesch.cranewebbackend.dto.PerformDto;
import com.cranesch.cranewebbackend.dto.PerformSessionDto;
import com.cranesch.cranewebbackend.entity.enums.PerformType;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.service.PerformService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PerformTest {
    @Autowired
    private PerformService performService;

    @Test
    public void PerformCreateTest(){
        PerformDto performDto = new PerformDto();
        performDto.setPerformName("22 정기공연");
        performDto.setPerformPlace("학생회관 소공연장");
        performDto.setPerformType(PerformType.REGULAR);
        performDto.setPerformDate(LocalDateTime.of(2022,01,01,15,00,00));

        performService.CreatePerform(performDto);
    }

    @Test
    public void MusicCreateTest()
    {
        MusicDto musicDto = new MusicDto();

        musicDto.setMusicName("소격동");
        musicDto.setMusicSinger("아이유");

        performService.CreateMusic(musicDto,Long.valueOf(3));
    }

    @Test
    public void SessionCreateTest()
    {
        PerformSessionDto sessionDto = new PerformSessionDto();

        sessionDto.setSession(Session.GUITAR);

        performService.CreatePerformSession(sessionDto, Long.valueOf(1),Long.valueOf(1));
    }
}
