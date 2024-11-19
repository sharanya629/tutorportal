package com.portal.entity;

//import org.apache.catalina.User;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tuition_requests", schema = "public")
public class TuitionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id")
    private User student;
    
    @ManyToOne
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;
    
    @NotBlank(message = "Status is mandatory")
    private String status; // PENDING, ACCEPTED, REJECTED
    
    @Column(name = "created_date", nullable = true, updatable = true)
    
    private Timestamp createdDate;

    @Column(name = "updated_date")
   
    private Timestamp updatedDate;
    
    public TuitionRequest() {
    	
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
}