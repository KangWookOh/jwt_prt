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
    private Long Reply_id;

    @Column(nullable = false, columnDefinition = "Text")
    private String Reply_comment;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    User user;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Board board;

    @Builder
    public Reply(String Reply_comment, User user, Board board){
        this.Reply_comment = Reply_comment;
        this.user = user;
        this.board = board;
    }

}
