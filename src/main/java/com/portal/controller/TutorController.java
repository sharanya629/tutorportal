package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portal.entity.Tutor;
import com.portal.service.TutorService;

import java.util.List;

@RestController

@RequestMapping("/tutors")
public class TutorController {

	private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Tutor> signUp(@RequestBody Tutor tutor) {
        Tutor savedTutor = tutorService.saveTutor(tutor);
        return new ResponseEntity<>(savedTutor, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Tutor>> searchTutors(@RequestParam String subject, @RequestParam String location) {
        List<Tutor> tutors = tutorService.searchTutors(subject, location);
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }
    
    @GetMapping("/welcome") 
    public String welcomeUser() {
    	return "Welcome to our application!";
    	
    }
}

