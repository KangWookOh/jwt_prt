package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.EqRepair;
import com.cranesch.cranewebbackend.entity.Equipment;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EqRepairDto {
    
    private LocalDate eqrDate;

    private String eqrPrice;

    private String eqrMemo;

    private Equipment equipment;

//    public EqRepair toEntity()
//    {
//        return EqRepair.builder().
//                eqrDate(eqrDate).
//                eqrPrice(eqrPrice).
//                eqrMemo(eqrMemo).
//                equipment(equipment).
//                build();
//    }
    @Builder
    public EqRepairDto(LocalDate eqrDate,String eqrPrice,String eqrMemo ,Equipment equipment)
    {
        this.eqrDate=eqrDate;
        this.eqrPrice=eqrPrice;
        this.eqrMemo=eqrMemo;
        this.equipment=equipment;
    }
}
