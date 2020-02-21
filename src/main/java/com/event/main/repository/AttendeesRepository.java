package com.event.main.repository;

import com.event.main.Model.AttendeesResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.event.main.Model.Attendees;

import java.util.List;

@Repository
public interface AttendeesRepository extends MongoRepository<Attendees, Long>{

    List<Attendees> findAllByMainEventId(String eventId);
}
