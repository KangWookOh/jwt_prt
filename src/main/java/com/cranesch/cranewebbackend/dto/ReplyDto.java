package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.Reply;
import com.cranesch.cranewebbackend.entity.User;
import lombok.Data;

@Data
public class ReplyDto {

    private String Reply_comment;

    private User user;

    private Board board;

    public Reply toEntity(){
        return Reply.builder()
                .Reply_comment(Reply_comment)
                .user(user)
                .board(board)
                .build();
    }
}
