package com.event.main.service;

import com.event.main.Model.Attendees;
import com.event.main.Model.Event;
import com.event.main.Model.Platform;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetupServiceImpl implements EventService {

    @Override
    public List<Event> getAllEvents() {
        return null;
    }

    @Override
    public List<Event> refreshEvents() {
        return null;
    }

    @Override
    public void refreshAttendeesOnEvent(Long platformEventId, Long eventId) {

    }

}
