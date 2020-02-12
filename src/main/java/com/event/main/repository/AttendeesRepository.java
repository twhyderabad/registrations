package com.event.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.event.main.Model.Attendees;

@Repository
public interface AttendeesRepository extends MongoRepository<Attendees, Long>{

}
