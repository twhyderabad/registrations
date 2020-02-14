package com.event.main.controller;

import com.event.main.Model.Attendees;
import com.event.main.Model.Event;
import com.event.main.service.EventbriteServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EventController {

    @Autowired
    private EventbriteServiceImpl eventbriteServiceImpl;

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventbriteServiceImpl.getAllEvents();
    }

    @GetMapping("/refresh-events")
    public List<Event> refreshEvents() throws JsonProcessingException {
        return eventbriteServiceImpl.refreshEvents();
    }

    @GetMapping("/attendees")
    public List<Attendees> getAttendees(@RequestParam("event_id") Long event_id) {
        return eventbriteServiceImpl.getAttendeesOnEvent(event_id);
    }

}
