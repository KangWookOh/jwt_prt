package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.TimeScheduleDto;
import com.cranesch.cranewebbackend.service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimeScheduleTest {

    @Autowired
    private ScheduleService scheduleService;

    @Test
    public void ScheduleCreateTest(){
        TimeScheduleDto tdto = new TimeScheduleDto();
        tdto.setTime_sub("창의공학설계");
        tdto.setTime_start(LocalDateTime.of(2022,12,3,00,00,00));
        tdto.setTime_end(LocalDateTime.of(2022,12,4,00,00,00));

        scheduleService.CreateTimeSchedule(tdto,Long.valueOf(1));
    }
}
