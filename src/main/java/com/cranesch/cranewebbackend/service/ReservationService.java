package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.EventDto;
import com.cranesch.cranewebbackend.dto.ReservationDto;
import com.cranesch.cranewebbackend.entity.Event;
import com.cranesch.cranewebbackend.entity.Reservation;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.EventRepository;
import com.cranesch.cranewebbackend.repository.ReservationRepository;
import com.cranesch.cranewebbackend.repository.TeamRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@AllArgsConstructor
public class ReservationService {

    private TeamRepository teamRepository;
    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private EventRepository eventRepository;

    @Transactional
    public Long CreateTeamReservation(ReservationDto dto, Long teamId) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isEmpty()) {
            throw new EntityExistsException("Team not exist");
        }
        Reservation reservation = Reservation.builder()
                .rsvDate(dto.getRsvDate())
                .rsvStart(dto.getRsvStart())
                .rsvFinish(dto.getRsvFinish())
                .team(optionalTeam.get())
                .user(null)
                .build();

        return reservationRepository.save(reservation).getId();
    }


    @Transactional
    public Long CreateUserReservation(ReservationDto dto, Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new EntityExistsException("User not exist");
        }
        Reservation reservation = Reservation.builder()
                .rsvDate(dto.getRsvDate())
                .rsvStart(dto.getRsvStart())
                .rsvFinish(dto.getRsvFinish())
                .team(null)
                .user(optionalUser.get())
                .build();

        return reservationRepository.save(reservation).getId();
    }

    @Transactional
    public Long CreateEvent(EventDto dto, Long userId, Long teamId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new EntityExistsException("User not found.");
        }

        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isEmpty()) {
            throw new EntityExistsException("Team not found");
        }

        Event event = Event.builder()
                .eventStartTime(dto.getEventStartTime())
                .eventEndTime(dto.getEventEndTime())
                .eventTitle(dto.getEventTitle())
                .eventContent(dto.getEventContent())
                .eventIsRoom(dto.isEventIsRoom())
                .build();
        return eventRepository.save(event).getId();
    }

    @Transactional(readOnly = true)
    public List<ReservationDto> ReadReservationByUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new EntityExistsException("User Not Exist");
        }
        List<Reservation> reservationList = reservationRepository.findByUserId(userId);
        List<ReservationDto> reservationDtoList = new ArrayList<>();

        for (Reservation r : reservationList) {
            ReservationDto dto = ReservationDto.builder()
                    .rsvDate(r.getRsvDate())
                    .rsvStart(r.getRsvStart())
                    .rsvFinish(r.getRsvFinish())
                    .team(r.getTeam())
                    .build();
            reservationDtoList.add(dto);
        }
        return reservationDtoList;
    }

    @Transactional(readOnly = true)
    public List<ReservationDto> ReadReservationByTeam(Long teamId) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isEmpty()) {
            throw new EntityExistsException("Team Not Exist");
        }
        List<Reservation> reservationList = reservationRepository.findByTeamId(teamId);
        List<ReservationDto> reservationDtoList = new ArrayList<>();

        for (Reservation r : reservationList) {
            ReservationDto dto = ReservationDto.builder()
                    .rsvDate(r.getRsvDate())
                    .rsvStart(r.getRsvStart())
                    .rsvFinish(r.getRsvFinish())
                    .build();
            reservationDtoList.add(dto);
        }
        return reservationDtoList;
    }

    @Transactional(readOnly = true)
    public List<EventDto> ReadEventList() {
        List<Event> eventList = eventRepository.findAll();
        List<EventDto> eventDtoList = new ArrayList<>();

        for(Event e : eventList){
            EventDto dto = EventDto.builder()
                    .eventTitle(e.getEventTitle())
                    .eventContent(e.getEventContent())
                    .eventStartTime(e.getEventStartTime())
                    .eventEndTime(e.getEventEndTime())
                    .eventIsRoom(e.isEventIsRoom())

                    .build();
            eventDtoList.add(dto);
        }
        return eventDtoList;
    }
    @Transactional
    public void DeleteEvent(Long eventId){
        Optional<Event> delEvent = eventRepository.findById(eventId);
        if(delEvent.isEmpty())
        {
            log.info("No event");
            throw new EntityExistsException("Event exist");
        }
        eventRepository.deleteById(eventId);
    }


    @Transactional
    public void DeleteReservation(Long reservationId){
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if(optionalReservation.isEmpty()){
            log.info("NoReservation");
            throw new EntityExistsException("Reservation is not exist");
        }

        reservationRepository.delete(optionalReservation.get());
    }
    /*@Transactional
    public void DelReservation(Long reservationId)
    {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if(optionalReservation.isEmpty())
        {
            throw new
        }*/
    }


