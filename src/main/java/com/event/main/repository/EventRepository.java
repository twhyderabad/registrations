package com.event.main.repository;

import com.event.main.Model.Attendees;
import com.event.main.Model.Event;
import com.event.main.Model.Platform;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, Long> {

}
