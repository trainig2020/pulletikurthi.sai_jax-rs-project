package com.messenger.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Profile implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;
	
	private String profileName;
	private String firstName;
	private String lastName;
	private Date created;
	
	/*
	 * @OneToMany private List<Message> mess ;
	 * 
	 * 
	 * public List<Message> getMess() { return mess; } public void
	 * setMess(List<Message> mess) { this.mess = mess;}
	 * 
	 */
	
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Profile(int profileId, String profileName, String firstName, String lastName, Date created) {
		super();
		this.profileId = profileId;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = created;
	}
	public Profile() {
		super();
	}
	
	
	
}
