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


    private LocalDateTime eventStartTime;
    private LocalDateTime eventEndTime;

    private String eventTitle;

    private String eventContent;

    private boolean eventIsRoom;

    @Builder
    private Event(LocalDateTime eventStartTime, LocalDateTime eventEndTime,
                  String eventTitle, String eventContent, boolean eventIsRoom)
    {
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.eventIsRoom = eventIsRoom;
    }
}
