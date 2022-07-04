package com.cranesch.cranewebbackend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class EqRepair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EqR_id;

    private String EqR_date;

    private String EqR_price;

    private String EqR_memo;

    @JoinColumn(name = "Eq_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Equipment Eq_id;

    @Builder
    private EqRepair(String EqR_date, String EqR_price, String EqR_memo, Equipment Eq_id)
    {
        this.EqR_date= EqR_date;
        this.EqR_price = EqR_price;
        this.EqR_memo = EqR_memo;
        this.Eq_id = Eq_id;
    }
}
