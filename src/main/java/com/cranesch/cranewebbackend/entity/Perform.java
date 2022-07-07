package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.Perform_Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Perform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Perform_id;

    private String Perform_name;

    private LocalDateTime Perform_date;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Perform_Type perform_type;

    private String Perform_place;

    @Builder
    public Perform(String Perform_name, LocalDateTime Perform_date, Perform_Type perform_type, String Perform_place){
        this.Perform_name = Perform_name;
        this.Perform_date = Perform_date;
        this.perform_type = perform_type;
        this.Perform_place = Perform_place;
    }
}
