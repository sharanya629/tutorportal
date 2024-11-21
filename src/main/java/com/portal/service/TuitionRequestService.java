package com.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.entity.TuitionRequest;
import com.portal.entity.Tutor;
import com.portal.entity.User;
import com.portal.exception.InvalidRequestException;
import com.portal.exception.UserNotFoundException;
import com.portal.repository.TuitionRequestRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TuitionRequestService {

    @Autowired
    private TuitionRequestRepository requestRepository;

    @Autowired
    private NotificationService notificationService;

    public TuitionRequest saveRequest(TuitionRequest request) {
        if (request.getStudent() == null || request.getTutor() == null) {
            throw new InvalidRequestException("Student and Tutor must be provided");
        }
        request.setCreatedDate((new Timestamp(System.currentTimeMillis())));
        TuitionRequest savedRequest = requestRepository.save(request);
        notificationService.sendNotification(request.getTutor().getUser(), "New tuition request from " + request.getStudent().getName());
        return savedRequest;
    }

    public List<TuitionRequest> getRequestsForTutor(Tutor tutor) {
        return requestRepository.findByTutor(tutor);
    }

    public List<TuitionRequest> getRequestsForStudent(User student) {
        return requestRepository.findByStudent(student);
    }

    public void updateRequestStatus(Integer requestId, String status) {
    	TuitionRequest request = requestRepository.findById(requestId).orElseThrow(() -> new UserNotFoundException("Request not found"));
        request.setStatus(status);
        request.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        requestRepository.save(request);
        notificationService.sendNotification(request.getStudent(), "Your request has been " + status.toLowerCase());
    }
    
    
}
