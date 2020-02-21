package com.event.main.service;

import com.event.main.Model.*;
import com.event.main.PlatformName;
import com.event.main.repository.AttendeesRepository;
import com.event.main.repository.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventbriteServiceImpl implements EventService {

    @Value("${com.event.main.event.get.url}")
    private String EVENT_GET_URL;

    @Value("${com.event.main.event.attendees.get.url}")
    private String EVENT_ATTENDEES_GET_URL;


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    EventRepository eventRepository;


    @Autowired
    AttendeesRepository attendeesRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    private Logger LOGGER = LoggerFactory.getLogger(EventbriteServiceImpl.class);

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEvent(Long eventId) {
        return eventRepository.findById(eventId);
    }

    @Override
    public List<Event> refreshEvents() {
        List<Event> savedEvents = new ArrayList<>();
        HttpEntity<String> entity = getHeaderHttpEntity();
        try {
            ResponseEntity<String> events = restTemplate.exchange(
                    EVENT_GET_URL,
                    HttpMethod.GET, entity, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            List<Event> eventList = objectMapper.readValue(events.getBody(), Events.class).getEvents();
            savedEvents = eventRepository.saveAll(addPlatformDetails(eventList));

        } catch (Exception e) {
            LOGGER.error("ERROR" + e.toString());
        }
        return savedEvents;
    }

    private List<Event> addPlatformDetails(List<Event> allEvents) {

        return allEvents.stream().map(event -> {
            List<Platform> platforms = new ArrayList<>();
            platforms.add(new Platform(PlatformName.EVENTBRITE.name(), event.getId()));
            event.setPlatforms(platforms);
            event.setId(sequenceGeneratorService.generateSequence(Event.SEQUENCE_NAME));
            return event;
        }).collect(Collectors.toList());
    }

    @Override
    public void refreshAttendeesOnEvent(Long platformEventId, Long eventId) {
        HttpEntity<String> entity = getHeaderHttpEntity();
        try {
            ResponseEntity<String> events = restTemplate.exchange(
                    String.format(EVENT_ATTENDEES_GET_URL, platformEventId), HttpMethod.GET, entity,
                    String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            List<Attendees> attendees = objectMapper.readValue(events.getBody(), AttendeesResponse.class).getAttendees();
            attendeesRepository.saveAll(addMainEventId(attendees, eventId));
        } catch (Exception e) {
            LOGGER.error("error" + e.toString());
        }
    }

    private HttpEntity<String> getHeaderHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer RXUSUF4IRERVKUOL2EH6");
        return new HttpEntity<>(headers);
    }

    private List<Attendees> addMainEventId(List<Attendees> attendees, Long eventId) {
        return attendees.stream().map(attendee -> {
            attendee.setMainEventId(String.valueOf(eventId));
            attendee.setAttendance(false);
            return attendee;
        }).collect(Collectors.toList());
    }
}
