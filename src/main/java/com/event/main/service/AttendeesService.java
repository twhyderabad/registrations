package com.event.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.event.main.Model.Attendees;
import com.event.main.Model.AttendeesResponse;
import com.event.main.Model.Event;
import com.event.main.Model.Events;
import com.event.main.repository.AttendeesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	public List<Event> getAllEvents() throws JsonMappingException, JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer RXUSUF4IRERVKUOL2EH6");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> events = restTemplate.exchange(
				"https://www.eventbriteapi.com/v3/organizations/145300320016/events/?order_by=created_desc&page_size=500&status=completed",
				HttpMethod.GET, entity, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(events.getBody(), Events.class).getEvents();

	}

	public List<Attendees> getAttendeesOnEvent(Long eventId) throws JsonMappingException, JsonProcessingException {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer RXUSUF4IRERVKUOL2EH6");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> events = restTemplate.exchange(
				"https://www.eventbriteapi.com/v3/events/" + eventId + "/attendees/", HttpMethod.GET, entity,
				String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(events.getBody(), AttendeesResponse.class).getAttendees();

	}

}
