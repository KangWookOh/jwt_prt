package com.cranesch.cranewebbackend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate rsvDate;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDateTime rsvStart; // LocalTime쓰면 오류남
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDateTime rsvFinish;

    @JoinColumn(name = "team_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    @Builder
    private Reservation(User user, LocalDate rsvDate, LocalDateTime rsvStart, LocalDateTime rsvFinish, Team team)
    {
        this.user = user;
        this.rsvDate = rsvDate;
        this.rsvStart = rsvStart;
        this.rsvFinish = rsvFinish;
        this.team = team;
    }
}
