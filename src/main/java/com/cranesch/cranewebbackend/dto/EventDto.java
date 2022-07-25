package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Event;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import lombok.Builder;
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

//    public Event toEntity()
//    {
//        return Event.builder().
//                user(user).
//                team(team).
//                eventStartTime(eventStartTime).
//                eventEndTime(eventEndTime).
//                eventTitle(eventTitle).
//                eventContent(eventContent).
//                eventIsRoom(eventIsRoom).
//                build();
//    }

    @Builder
    public EventDto(User user, Team team, LocalDateTime eventStartTime, LocalDateTime eventEndTime, String eventTitle, String eventContent, boolean eventIsRoom){
        this.user = user;
        this.team = team;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.eventIsRoom = eventIsRoom;
    }
}
