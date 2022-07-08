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
    private Long replyId;

    @Column(nullable = false, columnDefinition = "Text")
    private String replyComment;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    User user;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Board board;

    @Builder
    public Reply(String replyComment, User user, Board board){
        this.replyComment = replyComment;
        this.user = user;
        this.board = board;
    }

}
