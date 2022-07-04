package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.EventDto;
import com.cranesch.cranewebbackend.dto.ReservationDto;
import com.cranesch.cranewebbackend.dto.TeamDto;
import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.EventRepository;
import com.cranesch.cranewebbackend.repository.ReservationRepository;
import com.cranesch.cranewebbackend.repository.TeamRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService {

    private TeamRepository teamRepository;
    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private EventRepository eventRepository;

    @Transactional
    public Long CreateTeamReservation(ReservationDto dto, Long Team_id) {
        Optional<Team> optionalTeam = teamRepository.findById(Team_id);
        if (!optionalTeam.isPresent()) {
            throw new EntityExistsException("Team not exist");
        }
        dto.setTeam_id(optionalTeam.get());

        return reservationRepository.save(dto.toEntity()).getRs_id();
    }


    @Transactional
    public Long CreateUserReservation(ReservationDto dto, Long User_id) {
        Optional<User> optionalUser = userRepository.findById(User_id);
        if (!optionalUser.isPresent()) {
            throw new EntityExistsException("User not exist");
        }
        dto.setUser_id(optionalUser.get());

        return reservationRepository.save(dto.toEntity()).getRs_id();
    }

    @Transactional
    public Long CreateEvent(EventDto dto, Long User_id, Long Team_id)
    {
        Optional<User> optionalUser = userRepository.findById(User_id);
        if(!optionalUser.isPresent()){
            throw new EntityExistsException("User not found.");
        }

        Optional<Team> optionalTeam = teamRepository.findById(Team_id);
        if(!optionalTeam.isPresent())
        {
            throw new EntityExistsException("Team not found");
        }

        dto.setUser_id(optionalUser.get());
        dto.setTeam_id(optionalTeam.get());
        return eventRepository.save(dto.toEntity()).getEvent_id();
    }
}