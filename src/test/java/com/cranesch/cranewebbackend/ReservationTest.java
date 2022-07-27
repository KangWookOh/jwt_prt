package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.EventDto;
import com.cranesch.cranewebbackend.dto.ReservationDto;
import com.cranesch.cranewebbackend.service.ReservationService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReservationTest {

    @Autowired
    private ReservationService reservationService;

    @Test
    @DateTimeFormat
    public void CreateTeamRsvTest()
    {
        ReservationDto trdto = ReservationDto.builder()
                .rsvDate(LocalDate.of(2022, 07, 21))
                .rsvStart(LocalDateTime.of(2020,12,30,1,17,23).withNano(0))
                .rsvFinish(LocalDateTime.of(2020,12,30,3,17,23).withNano(0))
                .build();

        reservationService.CreateTeamReservation(trdto, 3L);

    }

    @Test
    public void CreateUserRsvTest()
    {
        ReservationDto urdto = ReservationDto.builder()
                .rsvDate(LocalDate.of(2020,5, 14))
                .rsvStart(LocalDateTime.of(2020, 12,21,1,40,00))
                .rsvFinish(LocalDateTime.of(2020, 12, 22, 3, 30,31))
                .build();

        reservationService.CreateUserReservation(urdto, 1L);
    }

    @Test
    public void CreateEventTest()
    {
        EventDto edto = EventDto.builder()
                .eventTitle("School Festival")
                .eventContent("2021 School Festival Performence")
                .eventStartTime(LocalDateTime.of(2022,7,20, 3, 0,0))
                .eventEndTime(LocalDateTime.of(2022, 7,21,5,0,0))
                .eventIsRoom(false)
                .build();

        reservationService.CreateEvent(edto, 1L, 3L);
    }

    @Test
    public void ReadResByUserTest()
    {
        Long userId = 1L;
        List<ReservationDto> reservationDtoList = reservationService.ReadReservationByUser(userId);

        System.out.println("Reservation List By User "+ userId);
        for(ReservationDto r: reservationDtoList)
        {
            System.out.println("Reservation Date : " + r.getRsvDate() +" / From : "+ r.getRsvStart()+ "" +
                    " ~ To : " + r.getRsvFinish());
        }
    }

    @Test
    public void ReadResByTeamTest()
    {
        Long teamId = 1L;
        List<ReservationDto> reservationDtoList = reservationService.ReadReservationByTeam(teamId);

        System.out.println("Reservation List By User "+ teamId);
        for(ReservationDto r: reservationDtoList)
        {
            System.out.println("Reservation Date : " + r.getRsvDate() +" / From : "+ r.getRsvStart()+ "" +
                    "~ To : " + r.getRsvFinish());
        }
    }

    @Test
    public void ReadEventList(){
        List<EventDto> eventDtoList = reservationService.ReadEventList();

        for(EventDto e : eventDtoList){
            System.out.printf("행사명: " + e.getEventTitle() + "내용: " + e.getEventContent());
            System.out.printf("  //  행사 시간: " +e.getEventStartTime() + " ~ " + e.getEventEndTime() + "\n");
        }
    }

    @Test
    public void EventDeleteTest(){
        Long eventId = 1L;
        reservationService.DeleteEvent(eventId);
    }

    @Test
    public void ReservationDeleteTest(){
        Long reservationId = 1L;
        reservationService.DeleteReservation(reservationId);
    }
}
