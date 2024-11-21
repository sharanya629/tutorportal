package com.portal.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entity.TuitionRequest;
import com.portal.entity.Tutor;
import com.portal.entity.User;

public interface TuitionRequestRepository extends JpaRepository<TuitionRequest, Integer> {
    List<TuitionRequest> findByTutor(Tutor tutor);
    List<TuitionRequest> findByStudent(User student);

}
