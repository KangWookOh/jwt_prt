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
    private Long Rs_id;

    @JoinColumn(name = "User_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User User_id;

    @Column(nullable = false)
    private LocalDateTime Rs_date;

    private LocalDateTime Rs_start;

    private LocalDateTime Rs_finish;

    @JoinColumn(name = "Team_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Team Team_id;

    @Builder
    private Reservation(LocalDateTime Rs_date, LocalDateTime Rs_start, LocalDateTime Rs_finish)
    {
        this.Rs_date = Rs_date;
        this.Rs_start = Rs_start;
        this.Rs_finish = Rs_finish;
    }
}
