package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.BoardType;
import lombok.Builder;
import lombok.Data;

@Data
public class BoardDto {

    private String boardTitle;

    private String boardContents;

    private BoardType boardType;

    private User user;

    private Long boardView;

/*    public Board toEntity(){
        return Board.builder()
                .boardTitle(boardTitle)
                .boardContents(boardContents)
                .boardType(boardType)
                .boardView(boardView)
                .user(user)
                .build();
    }*/
    @Builder
    public BoardDto(String boardTitle, String boardContents, BoardType boardType, User user, Long boardView)
    {
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.boardType = boardType;
        this.user =user;
        this.boardView = boardView;
    }

}
