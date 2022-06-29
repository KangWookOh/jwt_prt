package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.Board_Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Board_id;

    @Column(nullable = false)
    private String Board_title;

    @Column(nullable = false, columnDefinition = "Text")
    private String Board_contents;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Board_Type Board_type;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    User user;

    @Builder
    public Board(String title, String contents, Board_Type type){
        this.Board_title = title;
        this.Board_contents = contents;
        this.Board_type = type;
    }
}
