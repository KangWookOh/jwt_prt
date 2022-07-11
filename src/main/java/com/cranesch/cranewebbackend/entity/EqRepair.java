package com.cranesch.cranewebbackend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class EqRepair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eqrDate;

    private String eqrPrice;

    private String eqrMemo;

    @JoinColumn(name = "equipment_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Equipment equipment;

    @Builder
    private EqRepair(String eqrDate, String eqrPrice, String eqrMemo, Equipment equipment)
    {
        this.eqrDate = eqrDate;
        this.eqrPrice = eqrPrice;
        this.eqrMemo = eqrMemo;
        this.equipment = equipment;
    }
}//여긴 왜 자꾸 빨간줄그어지나요 암것도 없는데 저만 그어지나요
