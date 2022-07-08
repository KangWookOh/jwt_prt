package com.cranesch.cranewebbackend.entity;

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
    private Long boardId;

    @Column(nullable = false)
    private String boardTitle;

    @Column(nullable = false, columnDefinition = "Text")
    private String boardContents;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BoardType boardType;

    @Column(nullable = false)
    private Long boardView;

    @JoinColumn(nullable = false)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User userId;

    @Builder
    public Board(User userId, String boardTitle, String boardContents, BoardType boardType, Long boardView){
        this.userId = userId;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.boardType = boardType;
        this.boardView = boardView;
    }
}
