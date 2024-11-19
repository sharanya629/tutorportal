package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portal.entity.TuitionRequest;
import com.portal.entity.Tutor;
import com.portal.entity.User;
import com.portal.repository.TutorRepository;
import com.portal.service.TuitionRequestService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/requests")

public class RequestController {

    @Autowired
    private TuitionRequestService tuitionRequestService;
    @Autowired
    private Tutor tutor;
    @Autowired
    private TutorRepository tutorRepository;

    @PostMapping("/createRequest")
    public TuitionRequest createRequest(@RequestBody TuitionRequest request) {
        return tuitionRequestService.saveRequest(request);
    }

//    @GetMapping("/tutor")
//    public List<TuitionRequest> getRequestsForTutor(@PathVariable Long tutorId) {
//        //Tutor tutor = new Tutor();
//        tutor.setId(tutorId);
//        return tuitionRequestService.getRequestsForTutor(tutor);
//    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<TuitionRequest>> getRequestsForStudent(@PathVariable int studentId) {
        User student = new User();
        student.setId(studentId);
        List<TuitionRequest> requests = tuitionRequestService.getRequestsForStudent(student);

        if (requests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(requests, HttpStatus.OK);
        }
    }

    @PutMapping("/{requestId}/status")
    public ResponseEntity<Void> updateRequestStatus(@PathVariable Long requestId, @RequestParam String status) {
        tuitionRequestService.updateRequestStatus(requestId, status);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
//    @PutMapping("/notification/{requestId}")
//    public void updateNotificationStatus(@PathVariable Long requestId) {
//    	tuitionRequestService.updateNotificationStatus(requestId);
//    }
}
