package com.userviewer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "USER_PROFILE")
public class User {
	
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long id;
    
    @NotBlank
    @Column(name = "NAME")
    private String name;
    
    @NotBlank
    @Column(name = "SURNAME")
    private String surname;
    
    @Column(name = "PROFILE_PIC")
    private String profilePicUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}

}
