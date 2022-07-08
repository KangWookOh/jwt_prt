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
    private Long eqrId;

    private String eqrDate;

    private String eqrPrice;

    private String eqRMemo;

    @JoinColumn(name = "eqId")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Equipment eqId;

    @Builder
    private EqRepair(String eqrDate, String eqrPrice, String eqrMemo, Equipment eqId)
    {
        this.eqrDate = eqrDate;
        this.eqrPrice = eqrPrice;
        this.eqRMemo = eqrMemo;
        this.eqId = eqId;
    }
}
