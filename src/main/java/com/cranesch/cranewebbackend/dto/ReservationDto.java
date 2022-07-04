package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Reservation;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDto {

    private User User_id;

    private LocalDateTime Rs_date;

    private LocalDateTime Rs_start;

    private LocalDateTime Rs_finish;

    private Team Team_id;

    private Reservation toEntity()
    {
        return Reservation.builder().
                user_id(User_id).
                Rs_date(Rs_date).
                Rs_start(Rs_start).
                Rs_finish(Rs_finish).
                team_id(Team_id).
                build();
    }
}
