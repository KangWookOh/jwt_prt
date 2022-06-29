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
    private Long Time_id;

    @Column(nullable = false)
    private String Time_sub;

    @Column(nullable = false)
    private LocalDateTime Time_start;

    @Column(nullable = false)
    private LocalDateTime Time_end;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private User user;

    @Builder
    public Timeschedule(String sub, LocalDateTime start, LocalDateTime end){
        this.Time_sub = sub;
        this.Time_start = start;
        this.Time_end = end;
    }
}
