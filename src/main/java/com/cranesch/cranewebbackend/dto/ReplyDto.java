package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.Reply;
import com.cranesch.cranewebbackend.entity.User;
import lombok.Data;

@Data
public class ReplyDto {

    private String replyComment;

    private User user;

    private Board board;

    public Reply toEntity(){
        return Reply.builder()
                .replyComment(replyComment)
                .user(user)
                .board(board)
                .build();
    }
}
