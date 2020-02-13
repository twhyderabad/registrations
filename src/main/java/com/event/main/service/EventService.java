package com.event.main.service;

import com.event.main.Model.Attendees;
import com.event.main.Model.Event;

import java.util.List;

public interface EventService {
    public List<Event> getAllEvents();

    public List<Attendees> getAttendeesOnEvent(Long eventId);
}
