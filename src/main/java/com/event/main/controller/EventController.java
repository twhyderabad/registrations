package com.event.main.controller;

import com.event.main.Model.Attendees;
import com.event.main.Model.Event;
import com.event.main.service.EventbriteServiceImpl;
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
    public List<Event> refreshEvents() {
        return eventbriteServiceImpl.refreshEvents();
    }

}
