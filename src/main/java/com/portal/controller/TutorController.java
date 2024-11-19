package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portal.entity.Tutor;
import com.portal.service.TutorService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tutors")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping("/signup")
    public Tutor signUp(@RequestBody Tutor tutor) {
        return tutorService.saveTutor(tutor);
    }

    @GetMapping("/search")
    public List<Tutor> searchTutors(@RequestParam String subject, @RequestParam String location) {
        return tutorService.searchTutors(subject, location);
    }
    
    @GetMapping("/welcome") 
    public String welcomeUser() {
    	return "Welcome to our application!";
    	
    }
}

