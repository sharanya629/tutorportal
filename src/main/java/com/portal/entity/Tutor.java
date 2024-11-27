package com.portal.entity;
import org.springframework.stereotype.Component;

import com.portal.entity.User;

//import org.apache.catalina.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Column;

//import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "tutors", schema = "public")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
   @JoinColumn(name = "user_id", referencedColumnName = "id")
    
// @Column(name = "user_id")
    private User user;
   
    

    

   // @NotBlank(message = "Subject is mandatory")
    @Column(name = "subject")
    private String subject;
    @Column(name = "bio")
    private String bio;
    
    @Column(name = "tuition_fee")
    private float tuitionFee;
    
   

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSubject() {
		return subject;
	}

	
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public float getTuitionFee() {
		return tuitionFee;
	}

	public void setTuitionFee(float tuitionFee) {
		this.tuitionFee = tuitionFee;
	}

	
}