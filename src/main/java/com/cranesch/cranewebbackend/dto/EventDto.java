package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Event;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDto {

    private User user;

    private Team team;

    private LocalDateTime eventStartTime;
    private LocalDateTime eventEndTime;

    private String eventTitle;

    private String eventContent;

    private boolean eventIsRoom;

    public Event toEntity()
    {
        return Event.builder().
                user(user).
                team(team).
                eventStartTime(eventStartTime).
                eventEndTime(eventEndTime).
                eventTitle(eventTitle).
                eventContent(eventContent).
                eventIsRoom(eventIsRoom).
                build();
    }
}
