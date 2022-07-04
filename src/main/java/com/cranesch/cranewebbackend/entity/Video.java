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
    private Long Video_id;

    @Column(nullable = false)
    private String Video_url;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    @Builder
    public Video(String Video_url, Gallery gallery){
        this.Video_url = Video_url;
        this.gallery = gallery;
    }
}
