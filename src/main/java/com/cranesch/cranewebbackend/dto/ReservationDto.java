package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Reservation;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDto {

    private User user;

    private Team team;

    private LocalDateTime rsvDate;

    private LocalDateTime rsvStart;

    private LocalDateTime rsvFinish;

    public Reservation toEntity()
    {
        return Reservation.builder().
                user(user).
                rsvDate(rsvDate).
                rsvStart(rsvStart).
                rsvFinish(rsvFinish).
                team(team).
                build();
    }
}
