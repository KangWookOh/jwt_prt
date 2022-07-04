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

import java.time.LocalDateTime;

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
        EquipmentDto Edto = new EquipmentDto();
        Edto.setEq_name("fendar guitar");
        Edto.setEq_birth("2018-00-00");
        Edto.setEq_Session(Session.GUITAR);

        eqService.CreateEq(Edto);
    }

    @Test
    public void EqRCreateTest()
    {
        EqRepairDto eqrDto = new EqRepairDto();
        eqrDto.setEqR_date("2020.12.3");
        eqrDto.setEqR_memo("Body crack");
        eqrDto.setEqR_price("5$");

        eqService.CreateEqR(eqrDto, Long.valueOf(1));
    }

}
