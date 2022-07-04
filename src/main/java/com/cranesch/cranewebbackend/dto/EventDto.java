package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Event;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class EventDto {

    private Long Event_id;

    private User User_id;

    private Team Team_id;

    private LocalDateTime Event_startTime;
    private LocalDateTime Event_endTime;

    private String Event_title;

    private String Event_Content;

    private boolean Event_isRoom;

    private Event toEntity()
    {
        return Event.builder().
                User_id(User_id).
                Team_id(Team_id).
                Event_startTime(Event_startTime).
                Event_endTime(Event_endTime).
                Event_title(Event_title).
                Event_content(Event_Content).
                Event_isRoom(Event_isRoom).build();
    }
}
