package com.portal.entity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Mobile number should be 10 digits")
    @NotBlank(message = "Mobile number is mandatory")
    private String mobile;

    @NotBlank(message = "Location is mandatory")
    private String location;
    
    //@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\\\d)[A-Za-z\\\\d]{8,}$", message = "Password must be at least 8 characters long and include at least one letter and one number.")
    @NotBlank(message = "Password is mandatory")
    private String password;
    @NotBlank(message = "Role is mandatory")
    private String role;
    
    public User() {
    	
    }
    
    @JsonCreator
    public User(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("mobile") String mobile, @JsonProperty("location") String location,
    		@JsonProperty("role") String role) {
        this.id = id;
        this.name = name;
        
        this.mobile = mobile;
        this.location = location;
       
        this.role = role;
    }
    
    
	
	   
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}