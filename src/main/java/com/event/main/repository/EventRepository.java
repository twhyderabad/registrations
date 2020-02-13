package com.event.main.repository;

import com.event.main.Model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, Long> {
}
