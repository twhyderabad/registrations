package com.event.main.controller;

import com.event.main.Model.Attendees;
import com.event.main.Model.Event;
import com.event.main.Model.Platform;
import com.event.main.PlatformName;
import com.event.main.service.AttendeesService;
import com.event.main.service.EventbriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class AttendeesController {

    @Autowired
    private EventbriteServiceImpl eventbriteServiceImpl;

    @Autowired
    AttendeesService attendeesService;

    @PostMapping("/create")
    public Attendees create(@RequestBody Attendees attendees) {
        return attendeesService.create(attendees);
    }

    @GetMapping("/attendees")
    public List<Attendees> getAttendees(@RequestParam("event_id") Long event_id) {
        return attendeesService.getAttendeesOnEvent(String.valueOf(event_id));
    }

    @GetMapping("/refresh-attendees")
    public List<Attendees> refreshAttendeesOnEvent(@RequestParam("event_id") Long event_id) {
        Optional<Event> event = eventbriteServiceImpl.getEvent(event_id);
        if (event.isPresent()) {
            List<Platform> platforms = event.get().getPlatforms();
            platforms.stream().map(platform -> {
                if (platform.getPlatformName().equals(PlatformName.EVENTBRITE.name())) {
                    eventbriteServiceImpl.refreshAttendeesOnEvent(platform.getPlatformEventId(), event_id);
                }
                return platform;
            }).collect(Collectors.toList());
        } else {
            throw new NoSuchElementException();
        }
        return attendeesService.getAttendeesOnEvent(String.valueOf(event_id));
    }

}
