package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.dto.PictureDto;
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

    @JoinColumn(name = "board_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    public void UpdatePictureUrl(String pictureUrl){
        this.pictureUrl = pictureUrl;
    }

    @Builder
    public Picture(String pictureUrl, Board board){
        this.pictureUrl = pictureUrl;
        this.board = board;
    }
}
