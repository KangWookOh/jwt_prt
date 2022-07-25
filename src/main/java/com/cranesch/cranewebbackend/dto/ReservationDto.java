package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Reservation;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import jdk.jfr.Timestamp;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ReservationDto {

    private User user;

    private Team team;

    private LocalDate rsvDate;

    private LocalDateTime rsvStart;

    private LocalDateTime rsvFinish;

//    public Reservation toEntity()
//    {
//        return Reservation.builder().
//                user(user).
//                rsvDate(rsvDate).
//                rsvStart(rsvStart).
//                rsvFinish(rsvFinish).
//                team(team).
//                build();
//    }
    @Builder
    public ReservationDto(User user , Team team, LocalDate rsvDate,LocalDateTime rsvStart,LocalDateTime rsvFinish)
    {
        this.user=user;
        this.team=team;
        this.rsvDate=rsvDate;
        this.rsvStart=rsvStart;
        this.rsvFinish=rsvFinish;
    }
}
