package com.example.day_05.controller;

import com.example.day_05.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.day_05.dao.impl.PersonDAOImpl;
import com.example.day_05.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/people")
    public String people(Model model) {
        model.addAttribute("people", personService.getAllPeople());
        return "people";
    }
}
