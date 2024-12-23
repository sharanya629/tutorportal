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
@RequestMapping("/requests")

public class RequestController {

    @Autowired
    private TuitionRequestService tuitionRequestService;
    @Autowired
    private Tutor tutor;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private User user;

    @PostMapping("/createRequest")
    public TuitionRequest createRequest(@RequestBody TuitionRequest request) {
    	User studentId = request.getStudent();
    	Tutor tutorId = request.getTutor();
        return tuitionRequestService.saveRequest(request, studentId, tutorId);
    }

//    @GetMapping("/tutor")
//    public List<TuitionRequest> getRequestsForTutor(@PathVariable Long tutorId) {
//        //Tutor tutor = new Tutor();
//        tutor.setId(tutorId);
//        return tuitionRequestService.getRequestsForTutor(tutor);
//    }

    @GetMapping("/student/{studentId}")
   // public ResponseEntity<List<TuitionRequest>> getRequestsForStudent(@PathVariable int studentId) {
    public ResponseEntity<?> getRequestsForStudent(@PathVariable int studentId) {
        User student = new User();
        student.setId(studentId);
        List<TuitionRequest> requests = tuitionRequestService.getRequestsForStudent(student);

        if (requests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return  ResponseEntity.ok().header(null, null).body(requests);
        }
    }

    @PutMapping("/{requestId}/status")
    public ResponseEntity<Void> updateRequestStatus(@PathVariable int requestId, @RequestParam String status) {
        tuitionRequestService.updateRequestStatus(requestId, status);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
//    @PutMapping("/notification/{requestId}")
//    public void updateNotificationStatus(@PathVariable Long requestId) {
//    	tuitionRequestService.updateNotificationStatus(requestId);
//    }
}
