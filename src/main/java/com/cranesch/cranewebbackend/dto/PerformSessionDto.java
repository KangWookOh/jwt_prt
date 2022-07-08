package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Music;
import com.cranesch.cranewebbackend.entity.PerformSession;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Session;
import lombok.Data;

@Data
public class PerformSessionDto {

    private Session session;

    private Music music;

    private User user;

    public PerformSession toEntity(){
        return PerformSession.builder()
                .session(session)
                .music(music)
                .user(user)
                .build();
    }
}
