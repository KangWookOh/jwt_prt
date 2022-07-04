package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Music;
import com.cranesch.cranewebbackend.entity.Perform;
import lombok.Data;

@Data
public class MusicDto {

    private String Music_name;

    private String Music_singer;

    private Perform perform;

    public Music toEntity(){
        return Music.builder()
                .Music_name(Music_name)
                .Music_singer(Music_singer)
                .perform(perform)
                .build();
    }
}
