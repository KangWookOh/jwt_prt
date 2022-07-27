package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.EqRepairDto;
import com.cranesch.cranewebbackend.dto.EquipmentDto;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.repository.EqRepairRepository;
import com.cranesch.cranewebbackend.repository.EquipmentRepository;
import com.cranesch.cranewebbackend.service.EqService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EqServiceTest {
    @Autowired
    private EqService eqService;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private EqRepairRepository eqRepairRepository;

    @Test
    public void eqCreateTest(){
        EquipmentDto Edto = EquipmentDto.builder()
                .eqBirth("2018-00-00")
                .eqSession(Session.GUITAR)
                .eqName("cracked guitar")
                .build();

        eqService.CreateEq(Edto);
    }

    @Test
    public void EqRCreateTest()
    {
        EqRepairDto eqrDto = EqRepairDto.builder()
                .eqrDate(LocalDate.of(2022, 12,25))
                .eqrMemo("Critical Body Crack")
                .eqrPrice("5.$")
                .build();

        eqService.CreateEqR(eqrDto, 1L);
    }

    @Test
    public void ReadEqTest()
    {
        List<EquipmentDto> equipmentDtoList = eqService.ReadEq();
        for(EquipmentDto e : equipmentDtoList)
        {
            System.out.println("Eqip Name: " + e.getEqName() + " / Equip Birth : " + e.getEqBirth()
            + "Eqip Session" + e.getEqSession());
        }
    }

    @Test
    public void ReadEqRepairTest() {
        Long eqId = 1L;
        List<EqRepairDto> eqRepairDtoList = eqService.ReadEqrByEq(eqId);

        System.out.println("Eqipment Id " + eqId +" Repair Chart");
        for (EqRepairDto e : eqRepairDtoList)
        {
            System.out.println("Repair Date :" + e.getEqrDate() + " / Memo : "+ e.getEqrMemo()
                    + " / Price : " + e.getEqrPrice());
        }
    }

    @Test
    public void DelEquipmentTest()
    {
        Long eqId = 2L;
        eqService.DelEquipment(eqId);
    }

    @Test
    public void DelEqRTest()
    {
        Long eqrId = 1L;
        eqService.DelEqr(eqrId);
    }

}
