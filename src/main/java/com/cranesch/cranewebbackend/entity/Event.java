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
    private Long eventId;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User userId;

    @JoinColumn(name = "teamId")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Team teamId;

    private LocalDateTime eventStartTime;
    private LocalDateTime eventEndTime;

    private String eventTitle;

    private String eventContent;

    private boolean eventIsRoom;

    @Builder
    private Event(User userId, Team teamId, LocalDateTime eventStartTime, LocalDateTime eventEndTime,
                  String eventTitle, String eventContent, boolean eventIsRoom)
    {
        this.userId = userId;
        this.teamId = teamId;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.eventIsRoom = eventIsRoom;
    }
}
