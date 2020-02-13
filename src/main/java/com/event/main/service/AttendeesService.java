package com.event.main.service;

import com.event.main.Model.Attendees;
import com.event.main.repository.AttendeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AttendeesService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AttendeesRepository attendeesRepository;

    public Attendees create(Attendees attendees) {
        return attendeesRepository.save(attendees);
    }

    public List<Attendees> getAll() {
        return attendeesRepository.findAll();
    }
}
