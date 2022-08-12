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
    private Long id;

    @Column(nullable = false)
    private String musicName;

    @Column(nullable = true)
    private String musicSinger;

    //private String perform_name;

    @JoinColumn(name = "perform_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perform perform;

    @JoinColumn(name="team_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    public void musicUpdate(String musicName, String musicSinger, Team team)
    {
        this.musicName = musicName;
        this.musicSinger = musicSinger;
        this.team = team;
    }

    @Builder
    public Music(String musicName, String musicSinger, Perform perform, Team team){
        this.musicName = musicName;
        this.musicSinger = musicSinger;
        this.perform = perform;
        this.team = team;
    }
}
