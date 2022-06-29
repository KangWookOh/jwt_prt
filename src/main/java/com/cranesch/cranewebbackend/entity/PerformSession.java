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
    private Long performSession_id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Session PerformSession_session;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "Music_id")
    private Music music;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private User user;

    @Builder
    public PerformSession(Session session){
        this.PerformSession_session = session;
    }
}
