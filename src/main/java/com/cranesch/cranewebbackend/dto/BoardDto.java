package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.BoardType;
import lombok.Data;

@Data
public class BoardDto {

    private String boardTitle;

    private String boardContents;

    private BoardType boardType;

    private User userId;

    private Long boardView;

    public Board toEntity(){
        return Board.builder()
                .boardTitle(boardTitle)
                .boardContents(boardContents)
                .boardType(boardType)
                .boardView(boardView)
                .userId(userId)
                .build();
    }
}
