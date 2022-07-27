package com.cranesch.cranewebbackend.entity;

import lombok.Builder;
import lombok.CustomLog;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String videoUrl;

    @JoinColumn(name = "board_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Builder
    public Video(String videoUrl, Board board){
        this.videoUrl = videoUrl;
        this.board = board;
    }
}
