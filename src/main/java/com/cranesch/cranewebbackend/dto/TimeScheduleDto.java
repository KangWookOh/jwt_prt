package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Timeschedule;
import com.cranesch.cranewebbackend.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeScheduleDto {
    private String timeSub;

    private LocalDateTime timeStart;

    private LocalDateTime timeEnd;

    private User user;

    public Timeschedule toEntity()
    {
        return Timeschedule.builder().
                timeSub(timeSub).
                timeStart(timeStart).
                timeEnd(timeEnd).
                user(user).
                build();
    }

}

