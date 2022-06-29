package com.cranesch.cranewebbackend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Event_id;

    @JoinColumn(name = "User_id")
    @ManyToOne
    private User User_id;

    @JoinColumn(name = "Team_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Team Team_id;

    private LocalDateTime Event_startTime;
    private LocalDateTime Event_endTime;

    private String Event_title;

    private String Event_content;

    private boolean Event_isRoom;

    @Builder
    private Event(User User_id, Team Team_id, LocalDateTime Event_startTime, LocalDateTime Event_endTime,
                  String Event_title, String Event_content, boolean Event_isRoom)
    {
        this.User_id= User_id;
        this.Team_id = Team_id;
        this.Event_startTime = Event_startTime;
        this.Event_endTime = Event_endTime;
        this.Event_title = Event_title;
        this.Event_content = Event_content;
        this.Event_isRoom = Event_isRoom;
    }
}
