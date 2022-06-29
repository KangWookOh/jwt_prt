package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.Perform_Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class Perform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Perform_id;

    private String Perform_name;

    private LocalDate Perform_date;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Perform_Type perform_type;

    private String Perform_place;

    @Builder
    public Perform(String name, LocalDate date, Perform_Type type, String place){
        this.Perform_name = name;
        this.Perform_date = date;
        this.perform_type = type;
        this.Perform_place = place;
    }
}
