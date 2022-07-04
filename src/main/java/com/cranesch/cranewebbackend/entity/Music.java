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
    private Long Music_id;

    @Column(nullable = false)
    private String Music_name;

    @Column(nullable = true)
    private String Music_singer;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "Perform_id")
    private Perform perform;

    @Builder
    public Music(String Music_name, String Music_singer, Perform perform){
        this.Music_name = Music_name;
        this.Music_singer = Music_singer;
        this.perform = perform;
    }
}
