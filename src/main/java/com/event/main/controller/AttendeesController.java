package com.event.main.controller;

import com.event.main.Model.Attendees;
import com.event.main.service.AttendeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
