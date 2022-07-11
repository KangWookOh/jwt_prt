package com.cranesch.cranewebbackend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private LocalDateTime rsvDate;

    private LocalDateTime rsvStart;

    private LocalDateTime rsvFinish;

    @JoinColumn(name = "team_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Team team;

    @Builder
    private Reservation(User user, LocalDateTime rsvDate, LocalDateTime rsvStart, LocalDateTime rsvFinish, Team team)
    {
        this.user = user;
        this.rsvDate = rsvDate;
        this.rsvStart = rsvStart;
        this.rsvFinish = rsvFinish;
        this.team = team;
    }
}
