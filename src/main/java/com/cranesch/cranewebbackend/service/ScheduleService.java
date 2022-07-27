package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.TimeScheduleDto;
import com.cranesch.cranewebbackend.entity.Timeschedule;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.TimescheduleRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

@Service
@AllArgsConstructor
public class ScheduleService {
    private TimescheduleRepository timescheduleRepository;
    private UserRepository userRepository;

    @Transactional
    public Long CreateTimeSchedule(TimeScheduleDto dto, Long userId)
    {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new EntityExistsException("User not Found");
        }
        Timeschedule timeschedule = Timeschedule.builder()
                .timeSub(dto.getTimeSub())
                .timeStart(dto.getTimeStart())
                .timeEnd(dto.getTimeEnd())
                .user(optionalUser.get())
                .build();

        return timescheduleRepository.save(timeschedule).getId();
    }

    @Transactional
    public List<TimeScheduleDto> ReadScheduleByUser(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new EntityExistsException("User not Exist");
        }
        List<Timeschedule> timescheduleList = timescheduleRepository.findByUserId(userId);
        List<TimeScheduleDto> timeScheduleDtoList = new ArrayList<>();

        for(Timeschedule s : timescheduleList){
            TimeScheduleDto dto = TimeScheduleDto.builder()
                    .timeSub(s.getTimeSub())
                    .user(s.getUser())
                    .timeStart(s.getTimeStart())
                    .timeEnd(s.getTimeEnd())
                    .build();

            timeScheduleDtoList.add(dto);
        }

        return timeScheduleDtoList;
    }

    @Transactional
    public void DelSchedule(Long scheduleId)
    {
        Optional<Timeschedule> optionalTimeschedule = timescheduleRepository.findById(scheduleId);
        if(optionalTimeschedule.isEmpty())
        {
            throw new EntityExistsException("Schedule Not Exist");
        }
        timescheduleRepository.deleteById(scheduleId);

    }

}
