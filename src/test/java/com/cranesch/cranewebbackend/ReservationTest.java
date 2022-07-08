package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.EventDto;
import com.cranesch.cranewebbackend.dto.ReservationDto;
import com.cranesch.cranewebbackend.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReservationTest {

    @Autowired
    private ReservationService reservationService;

    @Test
    public void CreateTeamRsvTest()
    {
        ReservationDto trdto = new ReservationDto();
        trdto.setRsvDate(LocalDateTime.now());
        trdto.setRsvStart(LocalDateTime.of(2020,12,12,0,0,0));
        trdto.setRsvFinish(LocalDateTime.of(2020, 12, 12, 3,30, 0));

        reservationService.CreateTeamReservation(trdto, Long.valueOf(1));

    }

    @Test
    public void CreateUserRsvTest()
    {
        ReservationDto urdto = new ReservationDto();
        urdto.setRsvDate(LocalDateTime.now());
        urdto.setRsvStart(LocalDateTime.of(2020,12,12,0,0,0));
        urdto.setRsvFinish(LocalDateTime.of(2020, 12, 12, 3,30, 0));

        reservationService.CreateUserReservation(urdto, Long.valueOf(1));
    }

    @Test
    public void CreateEventTest()
    {
        EventDto edto = new EventDto();

        edto.setEventTitle("Festival Perform");
        edto.setEventContent("2022 School Festival Perform");
       edto.setEventStartTime(LocalDateTime.of(2022,7,21,0,0,0));
        edto.setEventEndTime(LocalDateTime.of(2022,7,22,0,0,0));
        edto.setEventIsRoom(true);

        reservationService.CreateEvent(edto, Long.valueOf(1), Long.valueOf(1));
    }
}
