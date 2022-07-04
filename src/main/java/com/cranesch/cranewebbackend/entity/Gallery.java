package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.Gallery_Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Gallery_id;

    @Column(nullable = false)
    private String Gallery_title;

    @Column(nullable = false, columnDefinition = "Text")
    private String Gallery_content;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gallery_Type gallery_type;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    User user;

    @OneToOne
    Music music;

    @Builder
    public Gallery(String Gallery_title, String Gallery_contents, Gallery_Type Gallery_type, User user, Music music){
        this.Gallery_title = Gallery_title;
        this.Gallery_content = Gallery_contents;
        this.gallery_type = Gallery_type;
        this.user = user;
        this.music = music;
    }
}
