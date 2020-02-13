package com.event.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.main.Model.Attendees;
import com.event.main.Model.Event;
import com.event.main.service.AttendeesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@CrossOrigin
public class AttendeesController {


	@Autowired
	AttendeesService attendeesService;

	@PostMapping("/create")
	public Attendees create(@RequestBody Attendees attendees) {
		return attendeesService.create(attendees);
	}


	@GetMapping
	public List<Attendees> get(){
		return attendeesService.getAll();
	}

}
