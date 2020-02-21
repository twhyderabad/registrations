package com.event.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {


	@GetMapping
    public String main(Model model) {

        return "welcome"; //view
    }

}
