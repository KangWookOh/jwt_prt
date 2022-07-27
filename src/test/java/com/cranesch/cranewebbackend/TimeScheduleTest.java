package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.TimeScheduleDto;
import com.cranesch.cranewebbackend.service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimeScheduleTest {

    @Autowired
    private ScheduleService scheduleService;

    @Test
    public void ScheduleCreateTest(){
        TimeScheduleDto tdto = TimeScheduleDto.builder()
                .timeSub("크레인개론")
                .timeStart(LocalDateTime.of(2022,12,3,00,00,00))
                .timeEnd(LocalDateTime.of(2022,12,4,00,00,00))
                .build();

        scheduleService.CreateTimeSchedule(tdto,Long.valueOf(1));
    }

    @Test
    public void ReadScheduleByUserTest(){
       List<TimeScheduleDto> tsDto = scheduleService.ReadScheduleByUser(Long.valueOf(1));

       for(TimeScheduleDto t : tsDto){
           System.out.printf("Start Time : "+t.getTimeStart() + " / End Time : "+ t.getTimeEnd() +
                   " / Schedule Sub :"+ t.getTimeSub()+"\n");
       }
    }
    @Test
    public void DelScheduleTest()
    {
        Long scheduleId = 2L;
        scheduleService.DelSchedule(scheduleId);
    }
}
