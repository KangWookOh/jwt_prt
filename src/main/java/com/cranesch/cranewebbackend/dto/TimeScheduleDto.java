package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Timeschedule;
import com.cranesch.cranewebbackend.entity.User;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
public class TimeScheduleDto {
    private String Time_sub;

    private LocalDateTime Time_start;

    private LocalDateTime Time_end;

    private User user;

    public Timeschedule toEntity()
    {
        return Timeschedule.builder().
                sub(Time_sub).
                start(Time_start).
                end(Time_end).
                user(user).
                build();
    }

}

