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
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "team_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Team team;

    private LocalDateTime eventStartTime;
    private LocalDateTime eventEndTime;

    private String eventTitle;

    private String eventContent;

    private boolean eventIsRoom;

    @Builder
    private Event(User user, Team team, LocalDateTime eventStartTime, LocalDateTime eventEndTime,
                  String eventTitle, String eventContent, boolean eventIsRoom)
    {
        this.user = user;
        this.team = team;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.eventIsRoom = eventIsRoom;
    }
}
