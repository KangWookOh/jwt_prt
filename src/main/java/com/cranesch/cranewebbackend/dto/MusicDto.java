package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Music;
import com.cranesch.cranewebbackend.entity.Perform;
import lombok.Builder;
import lombok.Data;

@Data
public class MusicDto {

    private String musicName;

    private String musicSinger;

    private Perform perform;


//    public Music toEntity(){
//        return Music.builder()
//                .musicName(musicName)
//                .musicSinger(musicSinger)
//                .perform(perform)
//                .build();
//    }

    @Builder
    public MusicDto(String musicName, String musicSinger, Perform perform, String perform_name){
        this.musicName = musicName;
        this.musicSinger = musicSinger;
        this.perform = perform;
    }
}
