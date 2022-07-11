package com.cranesch.cranewebbackend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pictureUrl;

    @JoinColumn(name = "gallery_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Gallery gallery;

    @Builder
    public Picture(String pictureUrl, Gallery gallery){
        this.pictureUrl = pictureUrl;
        this.gallery = gallery;
    }
}
