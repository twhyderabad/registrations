package com.event.main.service;

import com.event.main.Model.Attendees;
import com.event.main.Model.AttendeesResponse;
import com.event.main.Model.Event;
import com.event.main.Model.Events;
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

@Service
public class EventbriteServiceImpl implements EventService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    EventRepository eventRepository;


    @Autowired
    AttendeesRepository attendeesRepository;

    private Logger LOGGER = LoggerFactory.getLogger(EventbriteServiceImpl.class);

    @Override
    public List<Event> getAllEvents() {
        List<Event> allEvents = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer RXUSUF4IRERVKUOL2EH6");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            ResponseEntity<String> events = restTemplate.exchange(
                    "https://www.eventbriteapi.com/v3/organizations/145300320016/events/?order_by=created_desc&page_size=500&status=completed",
                    HttpMethod.GET, entity, String.class);
            System.out.println("events" + events);
            ObjectMapper objectMapper = new ObjectMapper();
            allEvents = objectMapper.readValue(events.getBody(), Events.class).getEvents();
            eventRepository.saveAll(allEvents);

        } catch (Exception e) {
            LOGGER.error("ERROR" + e);
        }
        return allEvents;
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
            LOGGER.error("error" + e);
        }
        return attendees;
    }
}
