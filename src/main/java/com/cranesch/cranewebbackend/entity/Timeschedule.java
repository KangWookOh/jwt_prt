package com.cranesch.cranewebbackend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Timeschedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String timeSub;

    @Column(nullable = false)
    private LocalDateTime timeStart;

    @Column(nullable = false)
    private LocalDateTime timeEnd;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public void UpdateTimeschedule(String timeSub, LocalDateTime timeStart, LocalDateTime timeEnd){
        this.timeSub = timeSub;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }
    @Builder
    public Timeschedule(String timeSub, LocalDateTime timeStart, LocalDateTime timeEnd, User user){
        this.timeSub = timeSub;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.user = user;
    }
}
