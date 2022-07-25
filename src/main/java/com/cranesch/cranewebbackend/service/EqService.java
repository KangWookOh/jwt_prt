package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.EqRepairDto;
import com.cranesch.cranewebbackend.dto.EquipmentDto;
import com.cranesch.cranewebbackend.entity.EqRepair;
import com.cranesch.cranewebbackend.entity.Equipment;
import com.cranesch.cranewebbackend.repository.EqRepairRepository;
import com.cranesch.cranewebbackend.repository.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EqService {
    private EquipmentRepository equipmentRepository;
    private EqRepairRepository eqRepairRepository;

    @Transactional
    public Equipment CreateEq(EquipmentDto dto){
        Equipment equipment =Equipment.builder()
                .eqName(dto.getEqName())
                .eqSession(dto.getEqSession())
                .eqBirth(dto.getEqBirth())
                .build();
        return equipmentRepository.save(equipment);
    }

    @Transactional
    public Long CreateEqR(EqRepairDto dto, Long eqId)
    {
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(eqId);
        if(!optionalEquipment.isPresent()){
            throw new EntityExistsException("Eq is not exist");
        }
        EqRepair eqRepair =EqRepair.builder()
                .eqrPrice(dto.getEqrPrice())
                .eqrMemo(dto.getEqrMemo())
                .equipment(optionalEquipment.get())
                .eqrDate(dto.getEqrDate())
                .build();
        return eqRepairRepository.save(eqRepair).getId();

    }

    @Transactional(readOnly = true)
    public List<EquipmentDto> ReadEq()
    {
        List<Equipment> equipmentList = equipmentRepository.findAll();
        List<EquipmentDto> equipmentDtoList = new ArrayList<>();

        for(Equipment e : equipmentList)
        {
            EquipmentDto dto = EquipmentDto.builder()
                    .eqName(e.getEqName())
                    .eqBirth(e.getEqBirth())
                    .eqSession(e.getEqSession())
                    .build();
            equipmentDtoList.add(dto);
        }
        return equipmentDtoList;
    }

    @Transactional(readOnly = true)
    public List<EqRepairDto> ReadEqrByEq(Long Eqid)
    {
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(Eqid);
        if(optionalEquipment.isEmpty())
        {
            throw new EntityExistsException("Equipment Not Exist");
        }
        List<EqRepair> eqRepairList = eqRepairRepository.findByEquipmentId(Eqid);
        List<EqRepairDto> eqRepairDtoList = new ArrayList<>();

        for(EqRepair r: eqRepairList)
        {
            EqRepairDto dto = EqRepairDto.builder()
                    .eqrDate(r.getEqrDate())
                    .eqrPrice(r.getEqrPrice())
                    .eqrMemo(r.getEqrMemo())
                    .build();
            eqRepairDtoList.add(dto);
        }
        return eqRepairDtoList;
    }
}
