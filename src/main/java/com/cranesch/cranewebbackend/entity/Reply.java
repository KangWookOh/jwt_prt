package com.cranesch.cranewebbackend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Reply extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "Text")
    private String replyComment;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    User user;

    @JoinColumn(name = "board_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Board board;

    @Builder
    public Reply(String replyComment, User user, Board board){
        this.replyComment = replyComment;
        this.user = user;
        this.board = board;
    }

}
