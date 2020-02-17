package com.event.main.service;

import com.event.main.Model.*;
import com.event.main.PlatformName;
import com.event.main.repository.AttendeesRepository;
import com.event.main.repository.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventbriteServiceImpl implements EventService {

    private String EVENT_GET_URL = "https://www.eventbriteapi.com/v3/organizations/145300320016/events/?order_by=created_desc&page_size=500&status=completed";


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    EventRepository eventRepository;


    @Autowired
    AttendeesRepository attendeesRepository;

    private Logger LOGGER = LoggerFactory.getLogger(EventbriteServiceImpl.class);

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> refreshEvents() {
        List<Event> savedEvents = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer RXUSUF4IRERVKUOL2EH6");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            ResponseEntity<String> events = restTemplate.exchange(
                    EVENT_GET_URL,
                    HttpMethod.GET, entity, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            List<Event> eventList = objectMapper.readValue(events.getBody(), Events.class).getEvents();

            List<Event> saveEvents = addPlatformDetails(eventList);
            System.out.println("events" + saveEvents);
            savedEvents = eventRepository.saveAll(saveEvents);

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
            event.setId(null);
            return event;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Attendees> getAttendeesOnEvent(Long eventId) {
        List<Attendees> attendees = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer RXUSUF4IRERVKUOL2EH6");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            ResponseEntity<String> events = restTemplate.exchange(
                    "https://www.eventbriteapi.com/v3/events/" + eventId + "/attendees/", HttpMethod.GET, entity,
                    String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            attendees = objectMapper.readValue(events.getBody(), AttendeesResponse.class).getAttendees();
            attendeesRepository.saveAll(attendees);
        } catch (Exception e) {
            LOGGER.error("error" + e.toString());
        }
        return attendees;
    }
}
