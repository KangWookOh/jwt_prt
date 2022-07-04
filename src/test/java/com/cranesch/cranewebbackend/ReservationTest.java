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
        trdto.setRs_date(LocalDateTime.now());
        trdto.setRs_start(LocalDateTime.of(2020,12,12,0,0,0));
        trdto.setRs_finish(LocalDateTime.of(2020, 12, 12, 3,30, 0));

        reservationService.CreateTeamReservation(trdto, Long.valueOf(1));

    }

    @Test
    public void CreateUserRsvTest()
    {
        ReservationDto urdto = new ReservationDto();
        urdto.setRs_date(LocalDateTime.now());
        urdto.setRs_start(LocalDateTime.of(2020,12,12,0,0,0));
        urdto.setRs_finish(LocalDateTime.of(2020, 12, 12, 3,30, 0));

        reservationService.CreateUserReservation(urdto, Long.valueOf(1));
    }

    @Test
    public void CreateEventTest()
    {
        EventDto edto = new EventDto();

        edto.setEvent_title("Festival Perform");
        edto.setEvent_Content("2022 School Festival Perform");
       edto.setEvent_startTime(LocalDateTime.of(2022,7,21,0,0,0));
        edto.setEvent_endTime(LocalDateTime.of(2022,7,22,0,0,0));
        edto.setEvent_isRoom(true);

        reservationService.CreateEvent(edto, Long.valueOf(1), Long.valueOf(1));
    }
}
