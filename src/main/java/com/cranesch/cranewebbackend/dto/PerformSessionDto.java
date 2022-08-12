//package com.cranesch.cranewebbackend.dto;
//
//import com.cranesch.cranewebbackend.entity.Music;
//import com.cranesch.cranewebbackend.entity.PerformSession;
//import com.cranesch.cranewebbackend.entity.User;
//import com.cranesch.cranewebbackend.entity.enums.Session;
//import lombok.Builder;
//import lombok.Data;
//import lombok.Getter;
//
//@Data
//@Getter
//public class PerformSessionDto {
//
//    private Session session;
//
//    private Music music;
//
//    private User user;
//
////    public PerformSession toEntity(){
////        return PerformSession.builder()
////                .session(session)
////                .music(music)
////                .user(user)
////                .build();
////    }
//    @Builder
//    public PerformSessionDto(Session session, Music music, User user)
//    {
//        this.session = session;
//        this.music = music;
//        this.user = user;
//    }
//}
