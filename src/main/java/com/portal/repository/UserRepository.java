package com.portal.repository;

//import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
		


