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
    private Long VideoId;

    @Column(nullable = false)
    private String videoUrl;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "galleryId")
    private Gallery gallery;

    @Builder
    public Video(String videoUrl, Gallery gallery){
        this.videoUrl = videoUrl;
        this.gallery = gallery;
    }
}
