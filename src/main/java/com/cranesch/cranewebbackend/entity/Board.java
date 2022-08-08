package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.BoardState;
import com.cranesch.cranewebbackend.entity.enums.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String boardTitle;

    @Column(nullable = false, columnDefinition = "Text")
    private String boardContents;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BoardType boardType;

    @Column(nullable = false)
    private int boardView;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BoardState boardState;

    @JoinColumn(nullable = false, name ="user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @JoinColumn(nullable = true, name="music_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Music music;



    public void updateBoard(String boardTitle,String boardContents,BoardType boardType)
    {
        this.boardTitle=boardTitle;
        this.boardContents=boardContents;
        this.boardType=boardType;

    }
    @Builder
    public Board(User user, Music music, String boardTitle, String boardContents, BoardType boardType, int boardView, BoardState boardState){
        this.user = user;
        this.music = music;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.boardType = boardType;
        this.boardState = boardState;
        this.boardView = boardView;
    }
}
