package com.cranesch.cranewebbackend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicId;

    @Column(nullable = false)
    private String musicName;

    @Column(nullable = true)
    private String musicSinger;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn
    private Perform perform;

    @Builder
    public Music(String musicName, String musicSinger, Perform perform){
        this.musicName = musicName;
        this.musicSinger = musicSinger;
        this.perform = perform;
    }
}
