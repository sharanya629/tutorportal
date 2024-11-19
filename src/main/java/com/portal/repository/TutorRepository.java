package com.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.entity.Tutor;



public interface TutorRepository extends JpaRepository<Tutor, Long> {
    List<Tutor> findBySubjectAndUser_Location(String subject, String location);
}