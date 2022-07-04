package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Board_Type;
import lombok.Data;

@Data
public class BoardDto {

    private String Board_title;

    private String Board_contents;

    private Board_Type Board_type;

    private User user_id;

    public Board toEntity(){
        return Board.builder()
                .Board_title(Board_title)
                .Board_contents(Board_contents)
                .Board_type(Board_type)
                .user_id(user_id)
                .build();
    }

}
