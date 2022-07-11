package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.Session;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class PerformSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Session session;

    @JoinColumn(name = "music_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Music music;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;

    @Builder
    public PerformSession(Session session, Music music, User user){
        this.session = session;
        this.music = music;
        this.user = user;
    }
}
