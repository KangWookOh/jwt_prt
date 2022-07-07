package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.MusicDto;
import com.cranesch.cranewebbackend.dto.PerformDto;
import com.cranesch.cranewebbackend.dto.PerformSessionDto;
import com.cranesch.cranewebbackend.entity.enums.Perform_Type;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.service.PerformService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PerformTest {
    @Autowired
    private PerformService performService;

    @Test
    public void PerformCreateTest(){
        PerformDto performDto = new PerformDto();
        performDto.setPerform_name("22 정기공연");
        performDto.setPerform_place("학생회관 소공연장");
        performDto.setPerform_type(Perform_Type.REGULAR);
        performDto.setPerform_date(LocalDateTime.of(2022,01,01,15,00,00));

        performService.CreatePerform(performDto);
    }

    @Test
    public void MusicCreateTest()
    {
        MusicDto musicDto = new MusicDto();

        musicDto.setMusic_name("소격동");
        musicDto.setMusic_singer("아이유");

        performService.CreateMusic(musicDto,Long.valueOf(3));
    }

    @Test
    public void SessionCreateTest()
    {
        PerformSessionDto sessionDto = new PerformSessionDto();

        sessionDto.setPerformSession_session(Session.GUITAR);

        performService.CreatePerformSession(sessionDto, Long.valueOf(1),Long.valueOf(1));
    }
}
