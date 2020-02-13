package com.event.main.service;

import com.event.main.Model.Attendees;
import com.event.main.Model.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetupServiceImpl implements EventService{

    @Override
    public List<Event> getAllEvents() {
        return null;
    }

    @Override
    public List<Attendees> getAttendeesOnEvent(Long eventId) {
        return null;
    }
}
