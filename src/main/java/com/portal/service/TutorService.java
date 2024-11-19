package com.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.entity.Tutor;
import com.portal.repository.TutorRepository;

@Service
public class TutorService {
    @Autowired
    private TutorRepository tutorRepository;

    public Tutor saveTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public List<Tutor> searchTutors(String subject, String location) {
        return tutorRepository.findBySubjectAndUser_Location(subject, location);
    }
}